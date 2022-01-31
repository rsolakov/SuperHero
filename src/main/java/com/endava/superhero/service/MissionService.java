package com.endava.superhero.service;

import com.endava.superhero.model.Mission;
import com.endava.superhero.model.SuperHero;

import java.util.Optional;

public interface MissionService {

    Mission save(Mission mission);

    Optional<Mission> findByName(String name);
}
