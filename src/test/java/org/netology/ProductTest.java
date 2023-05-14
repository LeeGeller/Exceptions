package org.netology;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void TestThereIsProduct() {

        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "Kiwi", 129);
        Product product2 = new Product(2, "Apple", 78);
        Product product3 = new Product(3, "Juice", 150);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.remove(2);

        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestThereIsNotProduct() {

        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "Kiwi", 129);
        Product product2 = new Product(2, "Apple", 78);
        Product product3 = new Product(3, "Juice", 150);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(6));
    }

    @Test
    public void testFindAll(){
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "Kiwi", 129);
        Product product2 = new Product(2, "Apple", 78);
        Product product3 = new Product(3, "Juice", 150);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Product[] expected = repo.findAll();
        Product [] actual = {product1, product2, product3};

        Assertions.assertArrayEquals(expected,actual);
    }
}
