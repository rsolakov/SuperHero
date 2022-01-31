package com.endava.superhero.service;

import com.endava.superhero.model.SuperHero;

import java.util.Optional;

public interface SuperHeroService {
    SuperHero save(SuperHero superHero);
    Optional<SuperHero> findById(Long id);

    boolean isNameUnique(String superHeroName);
}
