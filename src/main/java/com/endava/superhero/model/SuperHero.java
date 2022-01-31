package com.endava.superhero.model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "super_hero")
public class SuperHero {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(name = "first_name")
    private String firstName;
    @NotNull
    @Column(name = "last_name")
    private String lastName;
    @NotNull
    @Column(name = "super_hero_name")
    private String superHeroName;
    @NotNull
    @Column(unique = true)
    private String email;
    @NotNull
    private Date birthday;
    @ManyToMany(cascade = CascadeType.ALL, targetEntity = Mission.class, fetch = FetchType.LAZY)
    @JoinTable(name = "mission_super_hero",
            joinColumns = { @JoinColumn(name = "super_hero_id") },
            inverseJoinColumns = { @JoinColumn(name = "mission_id")})
    private List<Mission> missions = new ArrayList<>();


    public SuperHero() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuperHeroName() {
        return superHeroName;
    }

    public void setSuperHeroName(String superHeroName) {
        this.superHeroName = superHeroName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }
}
