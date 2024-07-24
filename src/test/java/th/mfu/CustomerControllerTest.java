package th.mfu;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class CustomerControllerTest {
    @Autowired
    private CustomerController controller;


    @Test
    public void createdAndGet(){
        controller = new CustomerController();
        //create a new customer
        Customer customer = new Customer();
        customer.setName("John Denver");
        customer.setAddress("123 Main st.");
        customer.setEmail("John@email.com");
        customer.setPhone("5285287894");

        ResponseEntity<String> response = controller.createCustomer(customer);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        
        //get customer out
        ResponseEntity<Customer> returnCust = controller.getCustomer(0);
        assertEquals(HttpStatus.OK, returnCust.getStatusCode());
        assertEquals("John Denver", returnCust.getBody().getName());
    }

    @Test
    public void deleteAndNotFound(){

        controller = new CustomerController();
        //create new customer
        Customer customer = new Customer();
        customer.setName("John Denver");
        customer.setAddress("123 Main st.");
        customer.setEmail("John@email.com");
        customer.setPhone("5285287894");

        controller.createCustomer(customer);

        //delete that customer
        ResponseEntity<String> response = controller.deleteCustomer(0);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        //get by id, shold reture 404
        ResponseEntity<Customer> response2 = controller.getCustomer(0);
        assertEquals(HttpStatus.NOT_FOUND, response2.getStatusCode());

    }
}
