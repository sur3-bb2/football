package com.example.football.demo.rest;

import com.example.football.demo.configurations.FootballApiConfig;
import com.example.football.demo.configurations.RestTemplateBean;
import com.example.football.demo.models.Competition;
import com.example.football.demo.models.Country;
import com.example.football.demo.models.Standing;
import com.example.football.demo.models.Team;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@EnableConfigurationProperties(value = FootballApiConfig.class)
@ContextConfiguration(classes = { RestTemplateBean.class })
@TestPropertySource("classpath:application.properties")
class SimpleClientTest {
    @Autowired
    FootballApiConfig config;

    @Autowired
    RestTemplate restTemplate;

    @Test
    void getCountries() {
        FootballApi client = new Client(config, restTemplate);
        List<Country> countries = client.getCountries();

        assertNotNull(countries);
        assertTrue(countries.size() > 0);
    }

    @Test
    void getCompetitions() {
        FootballApi client = new Client(config, restTemplate);
        List<Competition> competitions = client.getCompetitions("41");

        assertNotNull(competitions);
        assertTrue(competitions.size() > 0);
    }

    @Test
    void getTeams() {
        FootballApi client = new Client(config, restTemplate);
        List<Team> teams = client.getTeams("148");

        assertNotNull(teams);
        assertTrue(teams.size() > 0);
    }

    @Test
    void getStandings() {
        FootballApi client = new Client(config, restTemplate);
        List<Standing> standings = client.getStandings("148");

        assertNotNull(standings);
        assertTrue(standings.size() > 0);
    }
}