package com.example.football.demo.rest;

import com.example.football.demo.configurations.FootballApiConfig;
import com.example.football.demo.models.Competition;
import com.example.football.demo.models.Country;
import com.example.football.demo.models.Standing;
import com.example.football.demo.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Client implements FootballApi {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    FootballApiConfig config;

    public Client() { }

    public Client(FootballApiConfig config, RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.config = config;
    }

    @Override
    public List<Country> getCountries() {
        return restTemplate.exchange(config.getCountryGET(), HttpMethod.GET, null, new ParameterizedTypeReference<List<Country>>() {
        }).getBody();
    }

    @Override
    public List<Competition> getCompetitions(String countryId) {
        return restTemplate.exchange(config.getLeagueGET(countryId) + countryId,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Competition>>() {
        }).getBody();
    }

    @Override
    public List<Team> getTeams(String competitionId) {
        return restTemplate.exchange(config.getTeamGET(competitionId) ,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Team>>() {
                }).getBody();
    }

    @Override
    public List<Standing> getStandings(String competitionId) {
        return restTemplate.exchange(config.getStandingGET(competitionId),
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Standing>>() {
                }).getBody();
    }
}
