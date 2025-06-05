package com.data.repository;

import com.data.entity.Room;
import com.data.entity.Seat;

import java.util.List;

public interface SeatRepository {
    List<Seat> findAll();

}
