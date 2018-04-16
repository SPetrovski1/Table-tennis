package com.example.TableTennis.team;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class TeamService {

    public List<Team> teams = new ArrayList<>(Arrays.asList(
        new Team(1L, "prvTim", "Stefan", "Naum", 1, 0, 63, 33),
            new Team(2L, "vtorTim", "Dragan", "Dimitri", 1, 1, 96, 98),
            new Team(3L, "tretTim", "Jordan", "Ljubomir", 0, 1, 33, 63),
            new Team(4L, "cetvrtTim", "Aleksandar", "Afrim", 1, 0, 35, 63),
            new Team(5L, "pettiTim", "Dimitar", "Bojan", 2, 0, 156, 121),
            new Team(6L, "shestiTim", "Sinisha", "Jovica", 1, 1, 86, 93)
    ));

    public List<Team> getAllTeams(){
        return teams;
    }

    public Team getTeam(Long id){
        return teams.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTeam(Team team){
        teams.add(team);
    }

    public void updateTeam(Long id, Team team){
        for(int i=0; i<teams.size(); i++){
            Team t=teams.get(i);
            if(t.getId().equals(id)){
                teams.set(i,team);
                return;
            }
        }
    }

    public void deleteTopic(Long id){
        teams.removeIf(t -> t.getId().equals(id));

    }

    public Team getWinner(){

        try{


        Long currentWinnerId = 0L;
        int numberOfWins = teams.get(0).getWins();
        for(int i =1; i<teams.size(); i++){
            if(teams.get(i).getWins() > numberOfWins){
            currentWinnerId = Long.valueOf(i);
            }
        }


            return teams.get(Math.toIntExact(currentWinnerId));

        }catch (Exception e){
            System.out.println(e.getLocalizedMessage())  ;

            return null;

        }


    }

}
