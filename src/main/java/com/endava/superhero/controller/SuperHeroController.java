package com.endava.superhero.controller;

import com.endava.superhero.dto.SuperHeroDto;
import com.endava.superhero.exception.SuperHeroNotFound;
import com.endava.superhero.model.SuperHero;
import com.endava.superhero.service.SuperHeroService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/super-hero")
public class SuperHeroController {

    private SuperHeroService superHeroService;
    private ModelMapper modelMapper;

    public SuperHeroController(SuperHeroService superHeroService, ModelMapper modelMapper) {
        this.superHeroService = superHeroService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{id}")
    ResponseEntity<SuperHeroDto> findBySuperHeroName (@PathVariable(value = "id") Long id) throws SuperHeroNotFound {
        Optional<SuperHero> newSuperHero = superHeroService.findById(id);
        if (newSuperHero.isEmpty()) {
            throw new SuperHeroNotFound(id);
        }
        SuperHeroDto mappedName = modelMapper.map(newSuperHero, SuperHeroDto.class);
        return ResponseEntity.ok(mappedName);
    };

    @PostMapping
    ResponseEntity<SuperHeroDto> createNewHero(@Valid @RequestBody SuperHeroDto newSuperHero) {
        SuperHero superHero = modelMapper.map(newSuperHero, SuperHero.class);
        SuperHeroDto mappedDtoSuperHero = modelMapper.map(superHeroService.save(superHero), SuperHeroDto.class);
        return ResponseEntity.ok(mappedDtoSuperHero);
    }
}
