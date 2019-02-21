package com.slmanju.springreactive.repository;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Book {

    @Id
    private String id;
    private String title;

}
