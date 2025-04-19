package com.railgo.service;

import com.railgo.model.Train;
import com.railgo.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TrainService {
    @Autowired
    private TrainRepository trainRepository;

    public List<Train> searchTrains(String source, String destination, String classType, String date) {
        return trainRepository.findBySourceIgnoreCaseAndDestinationIgnoreCaseAndClassTypeIgnoreCaseAndDate(
            source, destination, classType, date);
    }
}
