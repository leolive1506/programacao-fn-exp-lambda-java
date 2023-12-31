package product.service;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import product.entities.Product;

public class ProductService {
  public double filteredSum(List<Product> list, Predicate<Product> criteria) {
    double sum = 0;
    for (Product p : list) {
      if (criteria.test(p)) {
        sum += p.getPrice();
      }
    }
    return sum;
  }
}
