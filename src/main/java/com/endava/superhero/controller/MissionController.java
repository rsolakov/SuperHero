package com.endava.superhero.controller;

import com.endava.superhero.dto.MissionDto;
import com.endava.superhero.dto.SuperHeroDto;
import com.endava.superhero.exception.MissionNameNotFound;
import com.endava.superhero.exception.SuperHeroNotFound;
import com.endava.superhero.model.Mission;
import com.endava.superhero.model.SuperHero;
import com.endava.superhero.service.MissionService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/missions")
public class MissionController {

    private MissionService missionService;
    private ModelMapper modelMapper;

    public MissionController(MissionService missionService, ModelMapper modelMapper) {
        this.missionService = missionService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("{missionName}")
    ResponseEntity<MissionDto> findByMissionName (@PathVariable(value = "missionName") String name) {
        Optional<Mission> newMission = missionService.findByName(name);
        if (newMission.isEmpty()) {
            throw new MissionNameNotFound(name);
        }
        MissionDto mappedName = modelMapper.map(newMission, MissionDto.class);
        return ResponseEntity.ok(mappedName);
    };

    @PostMapping
    ResponseEntity<MissionDto> createNewMission (@Valid @RequestBody MissionDto newMission) {
        Mission mission = modelMapper.map(newMission, Mission.class);
        MissionDto mappedMission = modelMapper.map(missionService.save(mission), MissionDto.class);
        return ResponseEntity.ok(mappedMission);
    }
}
