package com.medplus.service.users;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medplus.service.users.entity.DoctorEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Import(TestConfiguration.class)
class DoctorTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${local.server.port}")
    private int port;

    @Test
    void addDoctor() {

        String payload = """
                {
                   "dcID": "MPDC00006",
                    "firstName": "Viona",
                    "lastName": "Dubey",
                    "emailID": "vionadubey@gmail.com",
                    "phoneNumber": null,
                    "orgID": "MPOA00001"
                }
                """;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(payload, headers);
        restTemplate.postForEntity("http://localhost:"+port+"/doctor", request, String.class);

        ResponseEntity<DoctorEntity> getResponse = restTemplate.getForEntity("http://localhost:"+port+"/doctor/MPDC00006" , DoctorEntity.class);

        assertNotNull(getResponse);
        assertEquals("Viona",getResponse.getBody().getFirstName());

    }

       @Test
       void getAllDoctor() {


           ResponseEntity<List<DoctorEntity>> getResponse =restTemplate.exchange("http://localhost:"+port+"/doctor/all" ,HttpMethod.GET,null,new ParameterizedTypeReference<List<DoctorEntity>>(){});
           assertEquals(6,getResponse.getBody().size());
           List<String> names = List.of("Rohit","Nidhi","Kamal Nayan","Neha","Prisha","Viona");
           for(DoctorEntity de : getResponse.getBody()){
               assertTrue(names.contains(de.getFirstName()));
           }


       }




}
