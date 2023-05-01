package co.develhope.customqueries2.service;

import co.develhope.customqueries2.entities.FlightStatus;
import co.develhope.customqueries2.repositories.FlightRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    public String generateRandomString(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public FlightStatus getRandomStatus(){
        return FlightStatus.values()[new Random().nextInt(FlightStatus.values().length)];
    }

}
