package com.data.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false, columnDefinition = "VARCHAR(100)")
    private String roomName;

    @Column(columnDefinition = "int check(capacity > 0)")
    private int capacity;

    private String screenType;

    // false: Dang tam dung. true: Dang hoat dong
    private boolean status;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
    private List<RoomSeat> roomSeats;
}
