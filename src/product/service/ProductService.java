package product.service;

import java.util.List;

import product.entities.Product;

public class ProductService {
  public double filteredSum(List<Product> list) {
    double sum = 0;
    for (Product p : list) {
      if (p.getName().charAt(0) == 'T') {
        sum += p.getPrice();
      }
    }
    return sum;
  }
}
