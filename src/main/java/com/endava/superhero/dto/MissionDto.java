package com.endava.superhero.dto;

import com.endava.superhero.model.SuperHero;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class MissionDto {

    @NotNull
    @Size(min = 3)
    private String missionName;
    @NotNull
    private boolean isCompleted;
    private Set<SuperHero> superHero;
}
