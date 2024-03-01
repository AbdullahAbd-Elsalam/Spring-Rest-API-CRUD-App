package com.dummyApp.controller;

import com.dummyApp.Exception.EmptyException;
import com.dummyApp.Exception.ProductNotFoundError;
import com.dummyApp.Exception.TypeNotMatchException;
import com.dummyApp.Exception.response.ProductResponseError;
import com.dummyApp.model.JsonPlaceHolder;
import com.dummyApp.model.Product;
import com.dummyApp.model.ProductDetails;
import com.dummyApp.model.Student;
import com.dummyApp.service.ProductService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.function.EntityResponse;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


//@RestController  = @Controoer + @ResponseBody
@RestController
@Api(tags = "this is documentaion of rest of product controller class")
public class ProductController {

    // inject product service
    @Autowired
    ProductService productService;


 // get all product details
    @GetMapping(value = "/products/productDetails", consumes = "application/json", produces = "application/json")

     @ApiResponses( value = {
             @ApiResponse(code = 200,message = "successful request "),
             @ApiResponse(code = 404,message = "error for client"),
             @ApiResponse(code = 500,message = "error for server")
     }
     )
    @ApiOperation(value = "this is the operation which show all details by using productId")
     public ProductDetails showDetails(@RequestParam("id") int productId) throws ProductNotFoundError {

        // get object by product id
        Product product=productService.findById(productId);
        ProductDetails productDetails= product.getProductDetails();
        productDetails.setProduct(product);
        // throw product details into model
         return  productDetails  ;
    }





    // make processing to make update into database and retuen list of result
    @PutMapping(value = "/products" )
    @ApiOperation(value = "this operation  update  product Details by entering new productDetails  ")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "successful request "),
            @ApiResponse(code = 404,message = "error for client"),
            @ApiResponse(code = 500,message = "error for server")
    }
    )
    public ProductDetails  processUpdateAPI(@RequestBody ProductDetails productDetails  ) throws ProductNotFoundError, EmptyException, TypeNotMatchException {

        // update product

        productService.update(productDetails);
        // get list of product
       // List<Product> products=  productService.getAllProducts();
     return productDetails;
    }


    // process add product
    @PostMapping(value = "/products",consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "this is the insertion of porduct ")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "successful request "),
            @ApiResponse(code = 404,message = "error for client"),
            @ApiResponse(code = 500,message = "error for server")
    }
    )
   public  ProductDetails processAddProduct(@RequestBody ProductDetails productDetails ) throws EmptyException {

         // add product details into databasee
          productService.insert(productDetails);
        System.out.println("sucssufully saved");
        return productDetails ;
    }

    // delete products

    @DeleteMapping("/products/{productId}")
    @ApiOperation(value = "this is the deletion operation of product")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "successful request "),
            @ApiResponse(code = 404,message = "error for client"),
            @ApiResponse(code = 500,message = "error for server")
    }
    )
    public void processDeleteProduct(@PathVariable("productId") int id){

        // delete all products
        productService.deleteById(id);
        System.out.println("succssufully deleted");

    }

    // search by name

    @GetMapping("/products/search")
    @ApiOperation(value = "this is the operation get list of product details    by using name")
    public List<Product>  getAlldetails(  @RequestParam("name") String name ){

       List<Product>  products=  productService.search(name);

        return  products ;
    }

       @GetMapping("/products")
       @ApiResponses(value = {
               @ApiResponse(code = 200,message = "successful request "),
               @ApiResponse(code = 404,message = "error for client"),
               @ApiResponse(code = 500,message = "error for server")
       }
       )
        public Product  findById(@RequestParam("id") int id) throws ProductNotFoundError {


          return   productService.findById(id);

        // get object by product id


    }

    // test new api and ignore it from frontend team
    @GetMapping("/testapi")
    @ApiIgnore
    public String testapi(){

        return "test api successful";
    }

    // call another api
    @GetMapping("/calljsonapi")
    @ApiIgnore
    public String callAnotherAPI(){

         // define restTemplate
        RestTemplate restTemplate=new RestTemplate();
        // define url of another services
        String url  ="https://jsonplaceholder.typicode.com/posts/1";
          JsonPlaceHolder jsonPlaceHolder= restTemplate.getForObject(url, JsonPlaceHolder.class);
        return  jsonPlaceHolder.getTitle();
    }






}
