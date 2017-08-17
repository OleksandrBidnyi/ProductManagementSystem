package com.management.product.repository;

import com.management.product.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Aleksandr on 09.08.2017.
 */
public interface DataRepository<T extends Model> extends JpaRepository<T, Long> {
}
