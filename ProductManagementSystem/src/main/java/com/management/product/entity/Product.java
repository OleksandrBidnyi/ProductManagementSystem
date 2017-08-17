package com.management.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by Aleksandr on 09.08.2017.
 */

@Entity
@Table(name = "products")
public class Product extends Model {

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "manufacturer", nullable = false)
    private String manufacturer;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "cost")
    private int cost;


    public Product() {
        this.title = "";
        this.manufacturer = "";
        this.description = "";
    }

    public Product(String title, int cost) {
        this();
        setTitle(title);
        setCost(cost);
    }

    public Product(String title, String manufacturer, int cost) {
        this(title, cost);
        setManufacturer(manufacturer);
    }

    public Product(String title, String manufacturer, String description, int cost) {
        this(title, manufacturer, cost);
        setDescription(description);
    }

    @Override
    public String toString() {
        return "Product{" + super.toString() +
                "title='" + this.title + '\'' +
                ", manufacturer='" + this.manufacturer + '\'' +
                ", description='" + this.description + '\'' +
                ", cost=" + this.cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Product product = (Product) o;

        if (cost != product.cost) return false;
        if (!title.equals(product.title)) return false;
        if (!manufacturer.equals(product.manufacturer)) return false;
        return description.equals(product.description);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + manufacturer.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + cost;
        return result;
    }

    public String getTitle() {
        return this.title;
    }


    public void setTitle(String title) {
        this.title = isNotBlank(title) ? title : "";
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = isNotBlank(manufacturer) ? manufacturer : "";
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = isNotBlank(description) ? description : "";
    }

    public int getCost() {
        return this.cost;
    }

    public void setCost(int cost) {
        this.cost = cost > 0 ? cost : 0;
    }
}


