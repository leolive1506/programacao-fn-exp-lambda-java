package product;

import java.util.function.Predicate;

import product.entities.Product;

public class ProductPredicate implements Predicate<Product> {

  @Override
  public boolean test(Product product) {
    return product.getPrice() >= 100;
  }
}
