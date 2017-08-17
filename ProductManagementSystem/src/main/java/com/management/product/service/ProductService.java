package com.management.product.service;

import com.management.product.entity.Product;

/**
 * Created by Aleksandr on 10.08.2017.
 */
public interface ProductService extends DataService<Product> {

    Product getByTitle(String title);

    void removeByTitle(String title);
}
