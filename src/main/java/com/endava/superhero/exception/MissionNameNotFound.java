package com.endava.superhero.exception;

public class MissionNameNotFound extends RuntimeException{

    public MissionNameNotFound (String name) {
        super("Mission " + name + " is not found!");
    }
}
