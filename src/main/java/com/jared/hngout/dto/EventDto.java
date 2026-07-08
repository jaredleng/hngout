package com.jared.hngout.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EventDto {
    private Long id;
    private String eventName;
    private String category;
    private String dateTime;
    private String location;
    private int maxMembers;
    private Long organizerId;
    private String organizerName;
    private int currentMembers;
}