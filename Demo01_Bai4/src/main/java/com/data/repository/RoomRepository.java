package com.data.repository;

import com.data.entity.Room;

import java.util.List;

public interface RoomRepository {
    List<Room> findAll();

    Room findById(long id);

    boolean delete(long id);
}
