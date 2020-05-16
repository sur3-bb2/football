package com.example.football.demo.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "footballapi")
public class FootballApiConfig {
    private String host;
    private String apiKey;
    private String scheme;
    private String countryAction;
    private String competitionAction;
    private String teamAction;
    private String standingAction;

    private String url() { return scheme + "://" + host + "/?APIkey=" + apiKey; }

    public String getCountryGET() {
        return url() + countryAction;
    }

    public String getLeagueGET(String countryId) {
        return url() + competitionAction + countryId;
    }

    public String getTeamGET(String competitionId) {
        return url() + teamAction + competitionId;
    }

    public String getStandingGET(String competitionId) {
        return url() + standingAction + competitionId;
    }
    public void setHost(String host) {
        this.host = host;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public void setCountryAction(String countryAction) {
        this.countryAction = countryAction;
    }

    public void setCompetitionAction(String competitionAction) {
        this.competitionAction = competitionAction;
    }

    public void setTeamAction(String teamAction) {
        this.teamAction = teamAction;
    }

    public void setStandingAction(String standingAction) {
        this.standingAction = standingAction;
    }
}
