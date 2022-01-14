package org.springframework.samples.petclinic.feeding;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.Pet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Feeding extends BaseEntity {

    @NotBlank
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @Column(name = "start_date")
    private LocalDate startDate;

    @NotBlank
    @Positive
    @Column(name = "weeks_duration")
    private Double weeksDuration;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    @NotBlank
    @NotNull
    private Pet pet;  

    @ManyToOne
    @JoinColumn(name = "feeding_type")
    private FeedingType feedingType;
    

    
}
