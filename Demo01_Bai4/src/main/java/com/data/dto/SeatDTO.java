package com.data.dto;

import lombok.Data;

@Data
public class SeatDTO {

    private long id;

    private String seatName;

    private String roomName;

    // true: ghế bình thường, false: ghế hỏng
    private boolean statusSeat;

}
