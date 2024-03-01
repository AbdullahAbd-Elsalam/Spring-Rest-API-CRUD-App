package com.dummyApp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "product")
@Setter
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@ApiModel( value = "this is the api for product ")
 public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "this is the id for product")
    @Column(name = "id")
    private int id;


    @NotEmpty(message = "this field cannot be null")
    @Column(name = "name")
    private String name;


    // to define relation between two table and define forien key
    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "product_detail_id")
    private ProductDetails productDetails;


    public Product(String name){
        this.name=name;
    }

    public Product(int id){
        this.id=id;
    }
}
