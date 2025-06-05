package com.data.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class RoomDTO {

    private long id;

    private String roomName;

    private int capacity;

    private String screenType;

    // false: Dang tam dung. true: Dang hoat dong
    private boolean status;

}
