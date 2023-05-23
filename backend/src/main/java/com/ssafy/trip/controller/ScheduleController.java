package com.ssafy.trip.controller;

import com.ssafy.trip.Entity.Attraction;
import com.ssafy.trip.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/schedule")
@RestController
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<?> addSchedule(
            @RequestParam Integer day,
            @RequestParam Integer attractionId
            ,Authentication authentication) {
        String userId = authentication.getName();

        scheduleService.addSchedule(day,attractionId,userId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> listOfSchedule(Authentication authentication) {
        String userId = authentication.getName();

        List<Attraction>[] attractionList = scheduleService.scheduleOfDay(userId);

        return new ResponseEntity<>(attractionList,HttpStatus.OK);
    }
}