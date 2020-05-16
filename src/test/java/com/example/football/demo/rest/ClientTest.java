package com.example.football.demo.rest;

import com.example.football.demo.models.Competition;
import com.example.football.demo.models.Country;
import com.example.football.demo.models.Standing;
import com.example.football.demo.models.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientTest {
    @Autowired
    FootballApi client;

    @Test
    void getCountries() {
        List<Country> countries = client.getCountries();

        assertNotNull(countries);
        assertTrue(countries.size() > 0);
    }

    @Test
    void getCompetitions() {
        List<Competition> competitions = client.getCompetitions("41");

        assertNotNull(competitions);
        assertTrue(competitions.size() > 0);
    }

    @Test
    void getTeams() {
        List<Team> teams = client.getTeams("148");

        assertNotNull(teams);
        assertTrue(teams.size() > 0);
    }

    @Test
    void getStandings() {
        List<Standing> standings = client.getStandings("148");

        assertNotNull(standings);
        assertTrue(standings.size() > 0);
    }
}