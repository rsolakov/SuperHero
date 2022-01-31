package com.endava.superhero.service.impl;

import com.endava.superhero.model.Mission;
import com.endava.superhero.repository.MissionRepository;
import com.endava.superhero.service.MissionService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MissionServiceImpl implements MissionService {

    private final MissionRepository missionRepository;

    public MissionServiceImpl(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    @Override
    public Mission save(Mission mission) {
        return missionRepository.save(mission);
    }

    @Override
    public Optional<Mission> findByName(String name) {
        return Optional.ofNullable(missionRepository.findByMissionName(name));
    }

}
