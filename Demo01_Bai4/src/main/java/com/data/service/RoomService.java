package com.data.service;

import com.data.entity.Room;

import java.util.List;

public interface RoomService {
    List<Room> findAll();

    boolean delete(long id);
}
