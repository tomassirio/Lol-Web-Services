package com.tomassirio.LolWebServices.service;

import com.tomassirio.LolWebServices.model.Summoner;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

@Service
public class SummonerServiceImpl implements SummonerService{
    @Override
    public Summoner getSummonerByName(String summonerName, String region) throws IOException {
        StringBuilder sb = new StringBuilder()
                .append("https://")
                .append(region)
                .append(".api.riotgames.com/lol/summoner/v4/summoners/by-name/")
                .append(summonerName);
        URL urlForGetRequest = new URL(sb.toString());
        String readLine = null;
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("GET");
        conection.setRequestProperty("userId", "a1bcdef"); // set userId its a sample here
        int responseCode = conection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            } in .close();
            // print result
            System.out.println("JSON String Result " + response.toString());
            //GetAndPost.POSTRequest(response.toString());
        } else {
            System.out.println("GET NOT WORKED");
        }
        return null;
    }
}
