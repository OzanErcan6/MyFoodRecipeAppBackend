package com.project.springboost.repository;

import com.project.springboost.entity.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeDao extends CrudRepository<Recipe, Integer> {

}
