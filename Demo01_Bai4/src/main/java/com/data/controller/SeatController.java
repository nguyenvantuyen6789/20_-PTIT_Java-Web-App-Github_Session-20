package com.data.controller;

import com.data.dto.RoomDTO;
import com.data.dto.SeatDTO;
import com.data.entity.Room;
import com.data.entity.RoomSeat;
import com.data.entity.Seat;
import com.data.service.RoomService;
import com.data.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class SeatController {

    private final SeatService seatService;

    @GetMapping("seat-list")
    public String findAll(Model model) {
        List<Seat> seats = seatService.findAll();
        List<SeatDTO> seatDTOS = new ArrayList<>();

        seats.forEach(seat -> {
            List<RoomSeat> roomSeats = seat.getRoomSeats();
            if (roomSeats != null) {
                for (int i = 0; i < roomSeats.size(); i++) {
                    SeatDTO seatDTO2 = new SeatDTO();
                    seatDTO2.setId(seat.getId());
                    seatDTO2.setSeatName(seat.getSeatName());
                    // set status
                    seatDTO2.setStatusSeat(roomSeats.get(i).isStatus());
                    String roomName = roomSeats.get(i).getRoom().getRoomName();
                    // set cho seatDTO
                    seatDTO2.setRoomName(roomName);

                    // add seatDTO vào seatDTOS
                    seatDTOS.add(seatDTO2);
                }
            }
        });

        model.addAttribute("seatDTOS", seatDTOS);

        return "seat_list";
    }

}
