import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import product.entities.Product;

/**
 *  Fazer um programa para ler um conjunto de produtos a partir de um
    arquivo em formato .csv (suponha que exista pelo menos um produto).
    Em seguida mostrar o preço médio dos produtos. Depois, mostrar os
    nomes, em ordem decrescente, dos produtos que possuem preço
    inferior ao preço médio.
*/

public class ExAverage {
  public static void main() {
    String path = "../avg.csv";
    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
      List<Product> products = new ArrayList<>();
      String line = reader.readLine();

      while (line != null) {
        String[] fields = line.split(",");
        Product product = new Product(fields[0], Double.parseDouble(fields[1]));

        products.add(product);
        line = reader.readLine();
      }

      Integer size = products.size();
      Double average = products.stream()
        .map(p -> p.getPrice())
        .reduce(
          0.0,
          (x, y) -> x + y
        ) / size;

      System.out.println("Average price: " + String.format("%.2f", average));

      Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

      List<String> names = products.stream()  
        .filter(p -> p.getPrice() < average)
        .map(p -> p.getName())
        .sorted(comp.reversed())
        .toList();
      names.forEach(System.out::println);

    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
