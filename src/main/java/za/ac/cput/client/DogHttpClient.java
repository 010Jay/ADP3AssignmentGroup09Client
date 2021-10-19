package za.ac.cput.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.entity.Dog;

import java.util.Set;

public class DogHttpClient {

    private static RestTemplate restTemplate = new RestTemplate();

    private final static String CREATE_URL = "http://localhost:8080/dog/create";
    private final static String READ_URL = "http://localhost:8080/dog/read";
    private final static String UPDATE_URL = "http://localhost:8080/dog/update";
    private final static String DELETE_URL = "http://localhost:8080/dog/delete";
    private final static String GET_ALL_URL = "http://localhost:8080/dog/getAll";

    public static Dog create(Dog dog)
    {
        ResponseEntity<Dog> response = restTemplate.postForEntity(CREATE_URL, dog, Dog.class); //Create the request

        if(response.getStatusCode().equals(HttpStatus.OK)) //Return Dog object/null based on the response received
        {
            return response.getBody();
        }

        return null;
    }

    public static Dog read(Integer id)
    {
        String pathURL = READ_URL + "/" + id;

        ResponseEntity<Dog> response = restTemplate.getForEntity(pathURL, Dog.class);

        if(response.getStatusCode().equals(HttpStatus.OK))
        {
            return response.getBody();
        }

        return null;
    }

    public static Dog update(Dog dog)
    {
        ResponseEntity<Dog> response = restTemplate.postForEntity(UPDATE_URL, dog, Dog.class); //Create the request

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

    public static Set<Dog> getAll()
    {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity(null, headers);
        ResponseEntity<Set<Dog>> response = restTemplate.exchange(GET_ALL_URL, HttpMethod.GET, entity, new ParameterizedTypeReference<Set<Dog>>() {});

        if(response.getStatusCode().equals(HttpStatus.OK))
        {
            return response.getBody();
        }

        return null;
    }

    public static Dog[] rows()
    {
        int i = 0;
        Set<Dog> dogSet = getAll();
        Dog[] dogs = new Dog[dogSet.size()];

        for(Dog d : dogSet)
        {
            if(d != null)
            {
                dogs[i] = d;
                i++;
            }
        }

        return dogs;
    }
}

