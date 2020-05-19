package com.example.demo.service;

import com.example.demo.model.Animation;

import java.util.List;

public interface AnimationService {
    List<Animation> getAll();
    void save (Animation animation);
    Animation getById(int id);
    void update (Animation animation);
    void delete(int id);
}
