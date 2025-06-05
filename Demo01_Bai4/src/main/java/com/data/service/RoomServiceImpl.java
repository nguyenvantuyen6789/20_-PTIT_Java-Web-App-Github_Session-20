package com.data.service;

import com.data.entity.Room;
import com.data.repository.RoomRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    // dùng @RequiredArgsConstructor + final:
    // là dùng contructor
    private final RoomRepository roomRepo;

    @Override
    public List<Room> findAll() {
        return roomRepo.findAll();
    }

    @Override
    public boolean delete(long id) {
        return roomRepo.delete(id);
    }

}
