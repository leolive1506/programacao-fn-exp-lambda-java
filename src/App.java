import java.util.ArrayList;
import java.util.List;

import product.MyComparator;
import product.entities.Product;

public class App {
    public static void main(String[] args) throws Exception {
        List<Product> list = new ArrayList<>();
        list.add(new Product("TV", 900.0));
        list.add(new Product("Notebook", 1200.0));
        list.add(new Product("Tablet", 1200.0));

        // Collection.sort(list);
        list.sort(new MyComparator());

        for (Product p: list) {
            System.out.println(p);
        }
    }
}
