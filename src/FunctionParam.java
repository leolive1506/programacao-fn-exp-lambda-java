import java.util.ArrayList;
import java.util.List;

import product.entities.Product;
import product.service.ProductService;

public class FunctionParam {
  public static void main() {
    List<Product> list = new ArrayList<>();

    list.add(new Product("TV", 900.0));
    list.add(new Product("Mouse", 50.0));
    list.add(new Product("Tablet", 350.0));
    list.add(new Product("HD Case", 80.90));

    ProductService ps = new ProductService();
    double sum = ps.filteredSum(list, p -> p.getName().charAt(0) == 'T');
    double sumM = ps.filteredSum(list, p -> p.getName().charAt(0) == 'M');
    double sumMinus = ps.filteredSum(list, p -> p.getPrice() < 100);
    System.out.println("Sum = " + String.format("%.2f", sum));
    System.out.println("Sum = " + String.format("%.2f", sumM));
    System.out.println("Sum = " + String.format("%.2f", sumMinus));
  }
}
