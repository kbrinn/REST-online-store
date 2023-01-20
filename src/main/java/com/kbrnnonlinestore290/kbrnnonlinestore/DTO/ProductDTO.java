package com.kbrnnonlinestore290.kbrnnonlinestore.DTO;



import com.kbrnnonlinestore290.kbrnnonlinestore.model.Product;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ProductDTO {
    private int id;
    private @NotNull @Valid String name;
    private @NotNull @Valid String imageURL;
    private @NotNull @Valid String description;
    private @NotNull @Valid int categoryID;
    private @NotNull @Valid double price;

    public ProductDTO() {
    }

    public ProductDTO(@NotNull @Valid String name, @NotNull @Valid String imageURL, @NotNull @Valid String description, @NotNull @Valid int categoryID, @NotNull @Valid double price) {
        this.name = name;
        this.imageURL = imageURL;
        this.description = description;
        this.categoryID = categoryID;
        this.price = price;
    }

    public ProductDTO(Product product) {
        this.setId(product.getId());
        this.setName(product.getName());
        this.setImageURL(product.getImageURL());
        this.setDescription(product.getDescription());
        this.setPrice(product.getPrice());
        this.setCategoryId(product.getCategory().getId());
    }

    private void setCategoryId(int id) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", description='" + description + '\'' +
                ", categoryID=" + categoryID +
                ", price=" + price +
                '}';
    }
}
