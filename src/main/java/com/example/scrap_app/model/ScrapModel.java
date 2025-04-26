package com.example.scrap_app.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "scraps")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScrapModel {
    @Id
    private String id;
    @NotBlank(message = "Title cant be empty")
    private String title;
    @NotBlank(message = "Source cant be empty")
    private String source;
    @NotBlank(message = "Link cant be empty")
    private String link;

    private String image;
    @NotNull(message = "Date cant be empty")
    private LocalDateTime date;
}