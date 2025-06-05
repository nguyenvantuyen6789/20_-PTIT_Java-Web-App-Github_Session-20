package com.data.service;

import com.data.entity.Room;

import java.util.List;

public interface RoomService {
    List<Room> findAll();

    Room findById(long id);

    boolean delete(long id);
}
