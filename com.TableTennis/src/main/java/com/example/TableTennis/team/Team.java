package com.example.TableTennis.team;

import java.io.Serializable;

public class Team implements Serializable {
    private Long id;
    private String teamName;
    private String player1;
    private String player2;
    private int wins;
    private int loses;
    private int scoredPoints;
    private int lostPoints;

    public Team(Long id, String teamName, String player1, String player2, int wins, int loses, int scoredPoints, int lostPoints) {
        this.id = id;
        this.teamName = teamName;
        this.player1 = player1;
        this.player2 = player2;
        this.wins = wins;
        this.loses = loses;
        this.scoredPoints = scoredPoints;
        this.lostPoints = lostPoints;
    }

    public Team() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public int getScoredPoints() {
        return scoredPoints;
    }

    public void setScoredPoints(int scoredPoints) {
        this.scoredPoints = scoredPoints;
    }

    public int getLostPoints() {
        return lostPoints;
    }

    public void setLostPoints(int lostPoints) {
        this.lostPoints = lostPoints;
    }
}
