package com.management.product.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Aleksandr on 07.09.2017.
 */
public class ProductTest {

    @Test
    public void toStringTest() throws Exception {
        Product product = new Product("testTitle", "testManufacturer",
                "testDescription", 11111);
        String productToString = product.toString();
        assertTrue(productToString.contains("testTitle")
                && productToString.contains("testManufacturer")
                && productToString.contains("testDescription")
                && productToString.contains("11111"));
    }

    @Test
    public void equals() throws Exception {
        Product product = new Product("testTitle", "testManufacturer", "testDescription", 11111);
        Product product1 = new Product("testTitle", "testManufacturer", "testDescription", 11111);
        Product product2 = new Product("testTitle", "testManufacturer", "testDescription", 11111);
        assertTrue(product.equals(product));
        assertTrue(product.equals(product1));
        assertTrue(product1.equals(product));
        assertTrue(product1.equals(product2));
        assertTrue(product.equals(product2));
        product1.setCost(555);
        assertFalse(product.equals(product1));
        product2.setTitle("NewTestTitle");
        assertFalse(product.equals(product2));
        product.setTitle("NewTestTitle");
        product2.setManufacturer("NewTestManufacturer");
        assertFalse(product.equals(product2));
        product.setManufacturer("NewTestManufacturer");
        product2.setDescription("NewTestDescription");
        assertFalse(product.equals(product2));
        assertFalse(product.equals(null));
    }

    @Test
    public void hashCodeTest() throws Exception {
        Product product = new Product("testTitle", "testManufacturer", "testDescription", 11111);
        Product product1 = new Product("testTitle", "testManufacturer", "testDescription", 11111);
        assertTrue(product.hashCode() == product.hashCode());
        assertTrue(product.hashCode() == product1.hashCode());
        product.setTitle("NewTestTitle");
        assertFalse(product.hashCode() == product1.hashCode());
        product1.setTitle("NewTestTitle");
        product.setManufacturer("NewTestManufacturer");
        assertFalse(product.hashCode() == product1.hashCode());
        product1.setManufacturer("NewTestManufacturer");
        product.setDescription("NewTestDescription");
        assertFalse(product.hashCode() == product1.hashCode());
        product1.setDescription("NewTestDescription");
        product.setCost(555);
        assertFalse(product.hashCode() == product1.hashCode());
    }

    @Test
    public void getAndSetTitle() throws Exception {
        Product product = new Product();
        product.setTitle("NewTestTitle");
        assertEquals(product.getTitle(), "NewTestTitle");
        product.setTitle(" ");
        assertEquals(product.getTitle(), "");
    }

    @Test
    public void getAndSetManufacturer() throws Exception {
        Product product = new Product();
        product.setManufacturer("NewTestManufacturer");
        assertEquals(product.getManufacturer(), "NewTestManufacturer");
        product.setManufacturer(" ");
        assertEquals(product.getManufacturer(),"");
    }

    @Test
    public void getAndSetDescription() throws Exception{
        Product product = new Product();
        product.setDescription("NewTestDescription");
        assertEquals(product.getDescription(), "NewTestDescription");
        product.setDescription(" ");
        assertEquals(product.getDescription(),"");
    }

    @Test
    public void getAndSetCost() throws Exception{
        Product product = new Product();
        product.setCost(11111);
        assertEquals(product.getCost(), 11111);
        product.setCost(-11111);
        assertEquals(product.getCost(), 0);
    }
}