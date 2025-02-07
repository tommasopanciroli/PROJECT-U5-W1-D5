package com.example.project.project_u5_w1_d5.exceptions;

public class ItemNotFound extends RuntimeException {
    public ItemNotFound(long id) {
        super("Il record con id " + id + " non è stato trovato!");
    }
}
