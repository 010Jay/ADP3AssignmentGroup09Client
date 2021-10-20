package za.ac.cput.client;
 /*
    VeterinarianHttpClient.java
    Author: Nonhlahla Hlungwani (218160658)
    Date: 19 October 2021
 */
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.entity.Veterinarian;
import java.util.Set;

public class VeterinarianHttpClient {
    private static RestTemplate restTemplate = new RestTemplate();

    private final static String CREATE_URL = "http://localhost:8080/veterinarian/create";
    private final static String READ_URL = "http://localhost:8080/veterinarian/read";
    private final static String UPDATE_URL = "http://localhost:8080/veterinarian/update";
    private final static String DELETE_URL = "http://localhost:8080/veterinarian/delete";
    private final static String GET_ALL_URL = "http://localhost:8080/veterinarian/getAll";

    public static Veterinarian create(Veterinarian veterinarian) {
        ResponseEntity<Veterinarian> response = restTemplate.postForEntity(CREATE_URL, veterinarian, Veterinarian.class);

        if (response.getStatusCode().equals(HttpStatus.OK)) {
            return response.getBody();
        }
        return null;
    }

    public static Veterinarian read(Integer id) {
        String pathURL = READ_URL + "/" + id;

        ResponseEntity<Veterinarian> response = restTemplate.getForEntity(pathURL, Veterinarian.class);

        if (response.getStatusCode().equals(HttpStatus.OK)) {
            return response.getBody();
        }
        return null;
    }

    public static Veterinarian update(Veterinarian veterinarian)
    {
        ResponseEntity<Veterinarian> response = restTemplate.postForEntity(UPDATE_URL, veterinarian, Veterinarian.class); //Create the request

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

    public static Set<Veterinarian> getAll()
    {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity(null, headers);
        ResponseEntity<Set<Veterinarian>> response = restTemplate.exchange(GET_ALL_URL, HttpMethod.GET, entity, new ParameterizedTypeReference<Set<Veterinarian>>(){});

        if(response.getStatusCode().equals(HttpStatus.OK))
        {
            return response.getBody();
        }
        return null;
    }
    public static Veterinarian[] rows()
    {
        int i = 0;
        Set<Veterinarian> vetSet = getAll();
        Veterinarian[] veterinarians = new Veterinarian[vetSet.size()];

        for(Veterinarian vet : vetSet)
        {
            if(vet != null)
            {
                veterinarians[i] = vet;
                i++;
            }
        }

        return veterinarians;
    }
    }
