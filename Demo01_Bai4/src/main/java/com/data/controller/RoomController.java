package com.data.controller;

import com.data.dto.RoomDTO;
import com.data.entity.Room;
import com.data.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;
    // thymeleaf: hiện taại localhost:8080/room/list
    // a href = "add"> Add</a>

    @GetMapping("room-list")
    public String findAll(Model model) {
        List<Room> rooms = roomService.findAll();
        List<RoomDTO> roomDTOS = new ArrayList<>();

        rooms.forEach(room -> {
            RoomDTO roomDTO = new RoomDTO();
            roomDTO.setId(room.getId());
            roomDTO.setRoomName(room.getRoomName());
            roomDTO.setCapacity(room.getCapacity());
            roomDTO.setScreenType(room.getScreenType());
            roomDTO.setStatus(room.isStatus());

            roomDTOS.add(roomDTO);
        });
        model.addAttribute("roomDTOS", roomDTOS);

        return "room_list";
    }

    @GetMapping("room-detail/{id}")
    public String findById(@PathVariable long id,
                           Model model) {
        Room room = roomService.findById(id);
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId(room.getId());
        roomDTO.setRoomName(room.getRoomName());
        roomDTO.setCapacity(room.getCapacity());
        roomDTO.setScreenType(room.getScreenType());
        roomDTO.setStatus(room.isStatus());

        model.addAttribute("roomDTO", roomDTO);

        return "room_detail";
    }

    @GetMapping("room-delete/{id}")
    public String delete(@PathVariable long id) {
        roomService.delete(id);

        return "redirect:/room-list";
    }
}
