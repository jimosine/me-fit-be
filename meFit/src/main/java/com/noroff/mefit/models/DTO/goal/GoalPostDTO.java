package com.noroff.mefit.models.DTO.goal;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class GoalPostDTO {
    private String name;
    private String type;
    private LocalDate enddate;
}
