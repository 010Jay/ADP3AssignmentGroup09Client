package za.ac.cput.client;

/*
AdoptionRecordHttpClient.java
Http Client for the AdoptionRecord
Author:Siyanda Hlongwa (217091229)
Date:19 October 2021
 */

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.entity.AdoptionRecord;


import java.util.Set;

public class AdoptionRecordHttpClient {

    private static RestTemplate restTemplate = new RestTemplate();

    private final static String CREATE_URL = "http://localhost:8080/dog/create";
    private final static String READ_URL = "http://localhost:8080/dog/read";
    private final static String UPDATE_URL = "http://localhost:8080/dog/update";
    private final static String DELETE_URL = "http://localhost:8080/dog/delete";
    private final static String GET_ALL_URL = "http://localhost:8080/dog/getAll";


    public static AdoptionRecord create(AdoptionRecord adoptionRecord)
    {
        ResponseEntity<AdoptionRecord> response = restTemplate.postForEntity(CREATE_URL,adoptionRecord,AdoptionRecord.class);

        if(response.getStatusCode().equals(HttpStatus.OK))
        {
            return response.getBody();
        }
        return null;
    }

    public static AdoptionRecord read(Integer id)
    {
        String pathURL = READ_URL+ "/" + id;

        ResponseEntity<AdoptionRecord> response = restTemplate.getForEntity(pathURL,AdoptionRecord.class);

        if(response.getStatusCode().equals(HttpStatus.OK))
        {
            return response.getBody();
        }
        return null;
    }

    public static AdoptionRecord update(AdoptionRecord adoptionRecord)
    {
        ResponseEntity<AdoptionRecord> response = restTemplate.postForEntity(UPDATE_URL,adoptionRecord,AdoptionRecord.class);

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

    public static Set<AdoptionRecord> getAll()
    {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity(null, headers);
        ResponseEntity<Set<AdoptionRecord>> response = restTemplate.exchange(GET_ALL_URL, HttpMethod.GET, entity, new ParameterizedTypeReference<Set<AdoptionRecord>>(){});

        if(response.getStatusCode().equals(HttpStatus.OK))
        {
            return response.getBody();
        }
        return null;
    }


    public static AdoptionRecord[] rows() {
        int i = 0;
        Set<AdoptionRecord> adoptionRecordSet = getAll();
        AdoptionRecord[] adoptionRecords = new AdoptionRecord[adoptionRecordSet.size()];

        for (AdoptionRecord a : adoptionRecordSet) {
            if (a != null) {
                adoptionRecords[i] = a;
                i++;
            }
        }
        return adoptionRecords;

    }

}
