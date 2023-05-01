package co.develhope.customqueries1.controllers;

import co.develhope.customqueries1.entities.Flight;
import co.develhope.customqueries1.repositories.FlightRepository;
import co.develhope.customqueries1.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightRepository repoFlight;
    @Autowired
    FlightService flightService;

    @PostMapping("/create/{num}")
    public String createFlight(@PathVariable int num){
        flightService.createNames(num);
        return "Sono stati creati "+ num +" flights";
    }

    @GetMapping("/all")
    public List<Flight> getAll(){
        return repoFlight.findAll();
    }

}