package co.develhope.customqueries2.repositories;

import co.develhope.customqueries2.entities.Flight;
import co.develhope.customqueries2.entities.FlightStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    default Page<Flight> findAllByStatus(FlightStatus status, PageRequest request ){
        List <Flight> flightList = new ArrayList<>();
        for ( Flight flight : findAll() ) {
            if (flight.getStatus().equals(status)){
                flightList.add(flight);
            }
        }
        flightList.sort(Comparator.comparing(Flight::getFromAirport));
        Page<Flight> flightPage = new PageImpl<Flight>(flightList, request, flightList.size());
        return flightPage;
    }
    default List<Flight> getCustomFlight(FlightStatus status1, FlightStatus status2){
        List <Flight> flightList = new ArrayList<>();
        for ( Flight flight : findAll() ) {
            if (flight.getStatus().equals(status1) || flight.getStatus().equals(status2)){
                flightList.add(flight);
            }
        }
        return flightList;
    }

}