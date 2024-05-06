package com.project.springboost.repository;

import com.project.springboost.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientDao extends CrudRepository<Ingredient, Integer> {

}