// PnrSearchRepository.java
package com.railgo.repository;

import com.railgo.model.BookingModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PnrSearchRepository extends MongoRepository<BookingModel, String> {
    Optional<BookingModel> findByPnr(String pnr);
}