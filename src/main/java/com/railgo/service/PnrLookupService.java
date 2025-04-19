// PnrLookupService.java
package com.railgo.service;

import com.railgo.model.BookingModel;
import com.railgo.repository.PnrSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PnrLookupService {
    private final PnrSearchRepository pnrSearchRepository;
    
    @Autowired
    public PnrLookupService(PnrSearchRepository pnrSearchRepository) {
        this.pnrSearchRepository = pnrSearchRepository;
    }
    
    public Optional<BookingModel> findBookingByPnr(String pnr) {
        return pnrSearchRepository.findByPnr(pnr);
    }
}