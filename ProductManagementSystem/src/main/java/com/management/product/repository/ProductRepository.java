package com.management.product.repository;

import com.management.product.entity.Product;

/**
 * Created by Aleksandr on 09.08.2017.
 */
public interface ProductRepository extends DataRepository<Product> {

    Product findByTitle(String title);

    void deleteByTitle(String title);
}
