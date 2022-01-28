package com.endava.superhero.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "missions")
public class Mission {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "mission_name")
    @NotNull
    private String missionName;
    @Column(name = "is_completed")
    private boolean isCompleted;
    @ManyToMany(mappedBy = "missions")
    private Set<SuperHero> superHero;

    public Mission() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Set<SuperHero> getSuperHero() {
        return superHero;
    }

    public void setSuperHero(Set<SuperHero> superHero) {
        this.superHero = superHero;
    }
}
