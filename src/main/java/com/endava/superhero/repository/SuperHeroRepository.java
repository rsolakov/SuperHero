package com.endava.superhero.repository;

import com.endava.superhero.model.SuperHero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SuperHeroRepository extends JpaRepository<SuperHero, Long> {

}
