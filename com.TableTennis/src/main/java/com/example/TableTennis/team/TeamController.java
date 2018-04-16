package com.example.TableTennis.team;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    @RequestMapping("/")
    public String homePage(){return "Hello, this is the main page of the TableTennis application";}

    @RequestMapping("/teams")
    public List<Team> getAllTeams(){return teamService.getAllTeams();}

    @RequestMapping("/teams/{id}")
    public Team getTeam(@PathVariable Long id){
    return teamService.getTeam(id);
    }

    @RequestMapping("/teams/tournamentwinner")
    public Team getTournamentWinner(){
        return teamService.getWinner();
    }

    @RequestMapping(method = RequestMethod.POST, value="/teams")
    public void addTeam(@RequestBody Team team){
        teamService.addTeam(team);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/teams/{id}")
    public void updateTeam(@RequestBody Team team, @PathVariable Long id){
        teamService.updateTeam(id, team);
    }

    @RequestMapping(method=RequestMethod.DELETE, value = "/teams/{id}")
    public void deleteTeam(@PathVariable Long id) {
        teamService.deleteTopic(id);
    }


}