package pl.edu.pwr.mockwebapp2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideData {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ride.id")
    private Ride ride;

    private LocalDateTime time;
    private double speed;
    private double oilUsage;
    private double engineTemp;
}
