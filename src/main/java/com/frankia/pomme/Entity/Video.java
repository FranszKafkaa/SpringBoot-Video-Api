package com.frankia.pomme.Entity;

import com.frankia.pomme.Enum.VideoStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Nome é obrigatorio")
    private String name;

    @NotNull(message = "location é obrigatorio")
    private String location;

    @Enumerated(EnumType.ORDINAL)
    private VideoStatus videoStatus = VideoStatus.PROCESSING;
}
