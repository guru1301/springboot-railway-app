package com.railgo.controller;

import com.railgo.model.Train;
import com.railgo.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trains")
@CrossOrigin("*") // Allows requests from any frontend
public class TrainController {
    @Autowired
    private TrainService trainService;

    @GetMapping("/search")
    public List<Train> searchTrains(
            @RequestParam String source,
            @RequestParam String destination,
            @RequestParam String classType,
            @RequestParam String date) {
        return trainService.searchTrains(source, destination, classType, date);
    }
}
