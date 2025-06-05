package com.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "seat")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false, columnDefinition = "VARCHAR(10)")
    private String seatName;

    @OneToMany(mappedBy = "seat")
    private List<RoomSeat> roomSeats;
}
