package com.railgo.repository;

import com.railgo.model.BookingModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends MongoRepository<BookingModel, String> {
    // You can add custom query methods here if needed
}