package com.dummyApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "productdetail")
@Setter
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@ApiModel(value = "this is the api for productDetails ")
@Validated
public class ProductDetails {


    @Id
    @ApiModelProperty("this is the id for product details")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty(message = "this field cannot be null")
    @Size(min = 3,message = "the name should by greater than 3")
    @Column(name = "name")
    private String name;


    public ProductDetails(@NotEmpty(message = "this field cannot be null") @Size(min = 3,
                         message = "the name should by greater than 3") String name,
                          @NotNull(message = "this field cannot be null") Date expirationDate, @NotEmpty(message = "this field cannot be null") String manufacturer, @NotNull(message = "this field cannot be null") Double price,
                          @NotNull(message = "this field cannot be null") Boolean available) {
        this.name = name;
        this.expirationDate = expirationDate;
        this.manufacturer = manufacturer;
        this.price = price;
        this.available = available;
    }

    public ProductDetails(int id, @NotEmpty(message = "this field cannot be null") @Size(min = 3,
            message = "the name should by greater than 3") String name, @NotNull(message = "this field cannot be null") Date expirationDate, @NotEmpty(message = "this field cannot be null") String manufacturer, @NotNull(message = "this field cannot be null") Double price,
                          @NotNull(message = "this field cannot be null") Boolean available) {
        this.id = id;
        this.name = name;
        this.expirationDate = expirationDate;
        this.manufacturer = manufacturer;
        this.price = price;
        this.available = available;
    }

    @Temporal(TemporalType.DATE)
    @NotNull(message = "this field cannot be null")
    @Column(name = "expirationDate")
    private Date expirationDate;

    @NotEmpty(message = "this field cannot be null")
    @Column(name = "manufacturer")
    private String manufacturer;

    @NotNull(message = "this field cannot be null")
    @Column(name = "price")
    private Double price;


    @NotNull(message = "this field cannot be null")
    @Column(name = "available")
    private Boolean  available;





    @OneToOne(cascade = CascadeType.ALL,mappedBy = "productDetails" )
    @JsonIgnore
    private Product product;

    public ProductDetails(int id) {
        this.id = id;
    }
}
