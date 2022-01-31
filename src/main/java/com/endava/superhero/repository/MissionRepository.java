package com.endava.superhero.repository;

import com.endava.superhero.model.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {

    @Query("select m from Mission m where m.missionName = ?1")
    Mission findByMissionName(String name);
}
