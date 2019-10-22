package com.tomassirio.LolWebServices.service;


import com.tomassirio.LolWebServices.model.Summoner;

import java.io.IOException;
import java.net.ProtocolException;

public interface SummonerService {

    Summoner getSummonerByName(String summonerName, String region) throws IOException;
}
