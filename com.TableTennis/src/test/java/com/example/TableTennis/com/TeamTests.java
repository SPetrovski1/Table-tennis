
package com.example.TableTennis.com;


import com.example.TableTennis.team.Team;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.AssertTrue;
import java.util.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.springframework.http.HttpMethod.POST;


/**
 * @author stpetrovski on 2/7/2018
 * @project com.TableTennis
 *//*

*/

@SpringBootTest
public class TeamTests {

    public static final String BaseURL = "http://localhost:8081/teams/";

    @Test
    public void checkIfTeamExistsById() throws IOException {

        String number = "3";
        HttpUriRequest request = new HttpGet("http://localhost:8081/teams/" + number);

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    public void invalidIdTeamCheck() throws IOException {

        String number = "568";
        HttpUriRequest request = new HttpGet("http://localhost:8081/teams/" + number);

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_INTERNAL_SERVER_ERROR);

    }

    @Test
    public void postNewTeamAndCheckIfExists() throws IOException {
        Random random = new Random();
        int randomId = random.nextInt(50) + 7;
        HttpPost request = new HttpPost("http://localhost:8081/teams/" + randomId);
        Team team1 = new Team((long)randomId, "novTim", "newGuy1", "newGuy2", 5, 1, 196, 140);

         postNewTeamAndGetResponse(team1);
        HttpUriRequest request1 = new HttpGet("http://localhost:8081/teams/" + randomId);
        HttpResponse response = HttpClientBuilder.create().build().execute(request1);

        assertEquals(HttpStatus.SC_OK,response.getStatusLine().getStatusCode());


    }


    public ResponseEntity<Team> postNewTeamAndGetResponse(Team team){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity <Team> httpEntity = getHttpEntity(team);
        ResponseEntity<Team> response = restTemplate.exchange(BaseURL + team.getId().toString(), HttpMethod.POST, httpEntity, Team.class);

        return response;
    }

    private HttpEntity<Team> getHttpEntity(Team team){
        return new HttpEntity<Team>(team);



    }


}




