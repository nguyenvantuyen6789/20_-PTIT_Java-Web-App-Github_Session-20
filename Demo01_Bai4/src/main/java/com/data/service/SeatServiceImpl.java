package com.data.service;

import com.data.entity.Room;
import com.data.entity.Seat;
import com.data.repository.RoomRepository;
import com.data.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {

    // dùng @RequiredArgsConstructor + final:
    // là dùng contructor
    private final SeatRepository seatRepo;

    @Override
    public List<Seat> findAll() {
        return seatRepo.findAll();
    }

}
