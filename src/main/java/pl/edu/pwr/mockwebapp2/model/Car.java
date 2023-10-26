package pl.edu.pwr.mockwebapp2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user.id")
    private User user;

    private String model;
    private int year;
    private String manufacturer;
    private String vin;

    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Ride> rides = new ArrayList<>();
}