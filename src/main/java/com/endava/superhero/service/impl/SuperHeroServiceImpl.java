package com.endava.superhero.service.impl;

import com.endava.superhero.model.SuperHero;
import com.endava.superhero.repository.SuperHeroRepository;
import com.endava.superhero.service.SuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SuperHeroServiceImpl implements SuperHeroService {

    private final SuperHeroRepository superHeroRepository;

    @Autowired
    public SuperHeroServiceImpl(SuperHeroRepository superHeroRepository) {
        this.superHeroRepository = superHeroRepository;
    }

    @Override
    public SuperHero save(SuperHero superHero) {
        return superHeroRepository.save(superHero);
    }

    @Override
    public Optional<SuperHero> findById(Long id) {
        return superHeroRepository.findById(id);
    }

    @Override
    public boolean isNameUnique(String superHeroName) {
        return superHeroRepository.findBySuperHeroName(superHeroName).isEmpty();
    }
}
