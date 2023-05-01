package co.develhope.customqueries2.controllers;

import co.develhope.customqueries2.entities.Flight;
import co.develhope.customqueries2.entities.FlightStatus;
import co.develhope.customqueries2.repositories.FlightRepository;
import co.develhope.customqueries2.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private FlightService flightService;

    @GetMapping("/provisioning")
    public void provisionFlights(@RequestParam(required = false) Integer n){
        if(n == null) n=100;
        List<Flight> newFlights = new ArrayList<>();
        for(int i = 0; i < n; i++){
            Flight flight = new Flight();
            flight.setDescription(flightService.generateRandomString());
            flight.setFromAirport(flightService.generateRandomString());
            flight.setToAirport(flightService.generateRandomString());
            flight.setStatus(flightService.getRandomStatus());
            newFlights.add(flight);
        }
        flightRepository.saveAll(newFlights);
    }

    @GetMapping
    public Page<Flight> getAllFlights(@RequestParam int page, @RequestParam int size){
        return flightRepository.findAll(PageRequest.of(page, size, Sort.by("fromAirport").ascending()));
    }

    @GetMapping("/status/{status}")
    public Page<Flight> getAllFlightsByStatus(@PathVariable FlightStatus status, @RequestParam int page, @RequestParam int size){
        return flightRepository.findAllByStatus(status, (PageRequest.of(page, size)));
    }

    @GetMapping("/custom")
    public List<Flight> getCustomFlight(@RequestParam FlightStatus p1, @RequestParam FlightStatus p2){
        return flightRepository.getCustomFlight(p1, p2);
    }

}
