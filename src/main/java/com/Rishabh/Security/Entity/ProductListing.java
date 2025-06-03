package com.Rishabh.Security.Entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_product_listing")
public class ProductListing {

    @Id
    private String productId;
    private String productName;
    private String productDescription;
    private double price;
    private String category;

@Lob
    @Column(name = "image", columnDefinition = "BLOB")
    private byte[] imageData;

}
