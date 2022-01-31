package com.endava.superhero.exception;

public class SuperHeroNotFound extends Exception{

    public SuperHeroNotFound(Long id) {
        super("Hero with id " + id + " is not found!");
    }
}
