package co.develhope.customqueries1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String description;
    @Column
    private String fromAirport;
    @Column
    private String toAirport;
    @Column
    private Enum statusDefault;
    private enum status {ONTIME, DELAYED, CANCELLED};

    public Flight(String description, String fromAirport, String toAirport) {
        this.description = description;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.statusDefault = status.ONTIME;
    }
}