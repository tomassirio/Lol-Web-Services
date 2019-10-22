package com.tomassirio.LolWebServices.controller;

import com.tomassirio.LolWebServices.model.Summoner;
import com.tomassirio.LolWebServices.service.SummonerService;
import com.tomassirio.LolWebServices.utils.ErrorDetails;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/summoner")
public class summonerController {

    @Autowired
    private SummonerService summonerService;

    @ApiOperation(
            value = "Retrieve a summoner's info given it's name and region")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 400, message = "Bad request", response = ErrorDetails.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetails.class)

    })
    @RequestMapping(value = "/byName/{summonerName}", method = RequestMethod.GET)
    public ResponseEntity<String> findByName(@PathVariable(value = "summonerName") String summonerName, @PathVariable(value = "region") String region ) throws Exception {

        Summoner summoner = summonerService.getSummonerByName(summonerName, region);
        return ResponseEntity.status(HttpStatus.OK).body("Ok");
    }
}