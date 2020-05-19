package com.example.demo.model;

import java.util.List;

public interface AnimationDAO {
    void insertEntity(Animation animation);
    Animation findEntityByID(int id);
    List<Animation> findEntities();
    void updateEntity(Animation animation);
    void removeEntityByID(int id);
}
