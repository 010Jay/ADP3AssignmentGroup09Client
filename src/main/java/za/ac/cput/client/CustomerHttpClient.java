/*CustomerHttpClient.java
Http Client for the Customer
Author:Andy William Hine (219259038)
Date:19 October 2021
 */
package za.ac.cput.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.entity.Customer;


import java.util.Set;

public class CustomerHttpClient {

    private static RestTemplate restTemplate = new RestTemplate();

    private final static String CREATE_URL = "http://localhost:8080/dog/create";
    private final static String READ_URL = "http://localhost:8080/dog/read";
    private final static String UPDATE_URL = "http://localhost:8080/dog/update";
    private final static String DELETE_URL = "http://localhost:8080/dog/delete";
    private final static String GET_ALL_URL = "http://localhost:8080/dog/getAll";


    public static Customer create(Customer customer)
    {
        ResponseEntity<Customer> response = restTemplate.postForEntity(CREATE_URL,customer,Customer.class);

        if(response.getStatusCode().equals(HttpStatus.OK))
        {
            return response.getBody();
        }
        return null;
    }

    public static Customer read(Integer customerID)
    {
        String pathURL = READ_URL+ "/" + customerID;

        ResponseEntity<Customer> response = restTemplate.getForEntity(pathURL,Customer.class);

        if(response.getStatusCode().equals(HttpStatus.OK))
        {
            return response.getBody();
        }
        return null;
    }

    public static Customer update(Customer customer)
    {
        ResponseEntity<Customer> response = restTemplate.postForEntity(UPDATE_URL,customer,Customer.class);

        if(response.getStatusCode().equals(HttpStatus.OK))
        {
            return response.getBody();
        }
        return null;
    }

    public static void delete(Integer id)
    {
        String pathURL = DELETE_URL + "/" + id;

        restTemplate.delete(pathURL);
    }

    public static Set<Customer> getAll()
    {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity(null, headers);
        ResponseEntity<Set<Customer>> response = restTemplate.exchange(GET_ALL_URL, HttpMethod.GET, entity, new ParameterizedTypeReference<Set<Customer>>(){});

        if(response.getStatusCode().equals(HttpStatus.OK))
        {
            return response.getBody();
        }
        return null;
    }


    public static Customer[] rows() {
        int i = 0;
        Set<Customer> customerSet = getAll();
        Customer[] customers = new Customer[customerSet.size()];

        for (Customer c : customerSet) {
            if (c != null) {
                customers[i] = c;
                i++;
            }
        }
        return customers;

    }

}
