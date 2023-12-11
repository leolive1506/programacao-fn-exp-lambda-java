package product;

import java.util.function.Consumer;

import product.entities.Product;

public class ProductUpdate implements Consumer<Product> {

  @Override
  public void accept(Product p) {
    p.setPrice(p.getPrice() * 1.1);
  }
  
}
