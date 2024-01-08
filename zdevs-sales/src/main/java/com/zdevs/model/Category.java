package com.zdevs.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
//@Table(name = "tbl_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategory;
    @Column(nullable = false, length = 50)//name ="namecategory"
    private String name; //camelCase -> lowercase | upperCase | DB: snake_
    @Column(nullable = false,length = 50)// unique = true
    private String description;
    @Column(nullable = false)
    private boolean enabled;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
