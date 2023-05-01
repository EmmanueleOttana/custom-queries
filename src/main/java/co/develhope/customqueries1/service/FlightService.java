package co.develhope.customqueries1.service;

import co.develhope.customqueries1.entities.Flight;
import co.develhope.customqueries1.repositories.FlightRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;
@AllArgsConstructor
@Service
public class FlightService {

    FlightRepository flightRepository;

    public void createNames(int numName){
        String[] name = new String[3];
        for (int i = 0; i < numName*3; i++) {
            int leftLimit = 97; // letter 'a'
            int rightLimit = 122; // letter 'z'

            String generatedString = new Random().ints(leftLimit, rightLimit + 1)
                    .limit(10)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();

            if (name[0] == null) {
                name[0] = generatedString;
            } else if (name[1] == null) {
                name[1] = generatedString;
            } else if (name[2] == null) {
                name[2] = generatedString;
                flightRepository.saveAndFlush(new Flight(name[0], name[1], name[2]));
                name = new String[3];
            }
        }
    }



}

/*
=================== OLD METHOD ===================
     public void createName(){
        int[] intArray = new Random().ints(150).toArray();
        String[] name = new String[3];
        for (int i = 0; i < intArray.length; i++) {
            StringBuilder result = null;
            char[] letters = String.valueOf(intArray[i]).toCharArray();
            for (int y = 1 ; y < letters.length; y++ ) {
                int num = Integer.parseInt(String.valueOf(letters[y]));
                char letter = (char) ((int)(Math.random()*80+33+num));
                result.append(letter);
            }
            if(name[0] == null){name[0] = String.valueOf(result);}
            else if(name[1] == null){name[1] = String.valueOf(result);}
            else if(name[2] == null){name[2] = String.valueOf(result);}
            else { flightRepository.saveAndFlush( new Flight(name[0],name[1],name[2])) ;}
        }
    }
 */