package com.noroff.mefit.models.DTO.goal;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
public class AddProgramToGoalDTO {
   private Set<Integer> programIds;
}
