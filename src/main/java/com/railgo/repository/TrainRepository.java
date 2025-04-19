package com.railgo.repository;

import com.railgo.model.Train;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface TrainRepository extends MongoRepository<Train, String> {
    List<Train> findBySourceIgnoreCaseAndDestinationIgnoreCaseAndClassTypeIgnoreCaseAndDate(
        String source, String destination, String classType, String date);
}
