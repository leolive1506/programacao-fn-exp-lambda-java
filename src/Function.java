import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import product.ProductPredicate;
import product.ProductUpdate;
import product.UpperCaseName;
import product.entities.Product;

public class Function {
    public static void main() {
        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.0));
        list.add(new Product("Mouse", 50.0));
        list.add(new Product("Notebook", 1200.0));
        list.add(new Product("Tablet", 1200.0));        
        
        // List<String> names = list.stream().map(new UpperCaseName()).collect(Collectors.toList());
        // List<String> names = list.stream().map(Product::uppercaseName).collect(Collectors.toList());
        // List<String> names = list.stream().map(Product::nonStaticuppercaseName).collect(Collectors.toList());
        // Function<Product, String> fn = p -> p.getName().toUpperCase();
        List<String> names = list.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());
        names.forEach(System.out::println);
    }
}
