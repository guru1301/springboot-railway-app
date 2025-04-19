// PnrEnquiryController.java
package com.railgo.controller;

import com.railgo.model.BookingModel;
import com.railgo.service.PnrLookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pnr-status")
@CrossOrigin(origins = "*") // For development; restrict in production
public class PnrEnquiryController {
    private final PnrLookupService pnrLookupService;
    
    @Autowired
    public PnrEnquiryController(PnrLookupService pnrLookupService) {
        this.pnrLookupService = pnrLookupService;
    }
    
    @GetMapping("/check/{pnr}")
    public ResponseEntity<BookingModel> checkPnrStatus(@PathVariable String pnr) {
        return pnrLookupService.findBookingByPnr(pnr)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}