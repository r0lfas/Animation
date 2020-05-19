package com.example.demo.service;

import com.example.demo.model.Animation;
import com.example.demo.model.AnimationDAO;
import com.example.demo.model.Animation;
import com.example.demo.model.AnimationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class AnimationServiceImpl implements AnimationService {

    @Autowired
    @Qualifier("NumberDAO")
    private AnimationDAO animationDAO;

    @Override
    public List <Animation> getAll() {
        return animationDAO.findEntities();
    }

    @Override
    public void save(Animation animation) {
        animationDAO.insertEntity(animation);
    }

    @Override
    public Animation getById(int id) {
        return animationDAO.findEntityByID(id);
    }

    @Override
    public void update(Animation animation) {
        animationDAO.updateEntity(animation);
    }

    @Override
    public void delete(int id) {
        animationDAO.removeEntityByID(id);
    }

}
