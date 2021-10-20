package za.ac.cput.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.entity.Staff;

import java.util.Set;


public class StaffHttpClient {


    private static RestTemplate restTemplate = new RestTemplate();

    private final static String CREATE_URL = "http://localhost:8080/staff/create";
    private final static String READ_URL = "http://localhost:8080/staff/read";
    private final static String UPDATE_URL = "http://localhost:8080/staff/update";
    private final static String DELETE_URL = "http://localhost:8080/staff/delete";
    private final static String GET_ALL_URL = "http://localhost:8080/staff/getAll";

    public static Staff create(Staff staff)
    {
        ResponseEntity<Staff> response = restTemplate.postForEntity(CREATE_URL, staff, Staff.class); //Create the request

        if(response.getStatusCode().equals(HttpStatus.OK)) //Return Stuff object/null based on the response received
        {
            return response.getBody();
        }

        return null;
    }

    public static Staff read(Integer id)
    {
        String pathURL = READ_URL + "/" + id;

        ResponseEntity<Staff> response = restTemplate.getForEntity(pathURL, Staff.class);

        if(response.getStatusCode().equals(HttpStatus.OK))
        {
            return response.getBody();
        }

        return null;
    }

    public static Staff update(Staff staff)
    {
        ResponseEntity<Staff> response = restTemplate.postForEntity(UPDATE_URL, staff, Staff.class); //Create the request

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

    public static Set<Staff> getAll()
    {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity(null, headers);
        ResponseEntity<Set<Staff>> response = restTemplate.exchange(GET_ALL_URL, HttpMethod.GET, entity, new ParameterizedTypeReference<Set<Staff>>() {});

        if(response.getStatusCode().equals(HttpStatus.OK))
        {
            return response.getBody();
        }

        return null;
    }

    public static Staff[] rows()
    {
        int i = 0;
        Set<Staff> staffSet = getAll();
        Staff[] staff = new Staff[staffSet.size()];

        for(Staff s : staffSet)
        {
            if(s != null)
            {
                staff[i] = s;
                i++;
            }
        }

        return staff;
    }
}
