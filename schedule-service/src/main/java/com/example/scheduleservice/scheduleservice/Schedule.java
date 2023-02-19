package com.example.scheduleservice.scheduleservice;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
@Data
public class Schedule {
    Map<LocalDateTime, String> schedule = new LinkedHashMap<>();
}
