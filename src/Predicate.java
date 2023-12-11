import java.util.ArrayList;
import java.util.List;

import product.entities.Product;

public class Predicate {
    public static void main() {
        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.0));
        list.add(new Product("Mouse", 50.0));
        list.add(new Product("Notebook", 1200.0));
        list.add(new Product("Tablet", 1200.0));

        // list.removeIf(new ProductPredicate());
        // list.removeIf(Product::productPredicate);
        // list.removeIf(Product::nonStaticproductPredicate);
        // Predicate<Product> pred = product -> product.getPrice() >= 100;
        list.removeIf(product -> product.getPrice() >= 100);

        for (Product p : list) {
            System.out.println(p);
        }
    }
}
