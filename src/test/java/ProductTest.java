import com.dummyApp.model.Product;
import com.dummyApp.model.ProductDetails;
import com.sun.xml.internal.ws.policy.AssertionSet;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class ProductTest {

  private     RestTemplate restTemplate=new RestTemplate();
   private         SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-DD");

    // make test for founding products
    @Test
   public void testFindById(){
        // 1- define object of Rest template
        // 2- get object that want to test it
        String url="http://localhost:8080/products?id=17";
        ResponseEntity<Product> responseEntity= restTemplate.getForEntity(url,Product.class);
        // 3- use assertEquals to test the object
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

    // make test for insertion products
    @Test
    public void testInsertionProduct() throws ParseException {

     // put your object that want to insert it
         ProductDetails productDetails=new ProductDetails("lemmon",dateFormat.parse("2033-3-22"),
                "lemmon",33.0,true);


        // use restTemplate to get object after insertion into database
        String url="http://localhost:8080/products";
               ResponseEntity<ProductDetails> details=   restTemplate.postForEntity(url,productDetails,
                       ProductDetails.class);
        System.out.println(details);
        // test by name

        assertEquals(details.getBody().getName(),productDetails.getName());
    }


    // make test for deletion of product
    @Test
    public void testDeletionProduct() throws ParseException {



        // use restTemplate to get object after insertion into database
        String url="http://localhost:8080/products/33";
        // use rest template to do delete operation and retrive object to test it

           restTemplate.delete(url);
        String url2="http://localhost:8080/products?id=33";


        try {
            // Your RestTemplate request
            ResponseEntity<Product> responseEntity= restTemplate.getForEntity(url2,Product.class);
            // 3- use assertEquals to test the object
            assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());

        } catch (HttpClientErrorException.NotFound ex) {
            // Handle 404 error
            String responseBody = ex.getResponseBodyAsString();
            // Parse and handle the error response JSON
            System.out.println("404 Error: " + responseBody);
        }


    }

    // test for update of product
    @Test
     public void testUpdateProduct() throws ParseException {

        // 1- get raw you want to update it
        final int  productId=14;
        String url="http://localhost:8080/products";
        ProductDetails updatedDetails =new ProductDetails( productId,
                "zattonElmasry",dateFormat.parse("2033-3-22"),
                "zattonFarm",33.0,true);
         //2- Create HttpEntity with the updated product details
        HttpEntity<ProductDetails> requestEntity = new HttpEntity<>(updatedDetails);

        // Perform the PUT request
        ResponseEntity<ProductDetails> responseEntity = restTemplate.exchange(
                url, HttpMethod.PUT, requestEntity, ProductDetails.class, productId);

        // Assert the response status code (e.g., 200 OK)
        assertEquals(200, responseEntity.getStatusCodeValue());

        // Optionally, assert the response body or other aspects of the updated product
        ProductDetails updatedProduct = responseEntity.getBody();
        System.out.println(updatedProduct);
        assertEquals("zattonElmasry", updatedProduct.getName());
        // Add more assertions based on your specific use case

    }


}
