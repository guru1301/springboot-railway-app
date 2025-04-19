package com.railgo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "trains") // Tells Spring Boot this is a MongoDB collection
public class Train {
    @Id
    private String id;
    private String trainNumber;
    private String name;
    private String source;
    private String destination;
    private String classType;
    private String departureTime;
    private String arrivalTime;
    private String date;
    private double price;
}
