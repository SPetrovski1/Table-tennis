package com.example.TableTennis.winner;


import com.example.TableTennis.team.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WinnerController {

    @Autowired
    private WinnerService winnerService;

    @RequestMapping("/teams/winner")
    public Team showTeam(){
        RestTemplate restTemplate = new RestTemplate();
        Team object = restTemplate.getForObject("http://localhost:8081/teams/tournamentwinner", Team.class);
        return object;


//        return winnerService.getWinner();




    }
}
