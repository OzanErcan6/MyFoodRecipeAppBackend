package com.project.springboost.service;

import com.project.springboost.entity.Ingredient;
import com.project.springboost.entity.Recipe;
import com.project.springboost.entity.Tool;
import com.project.springboost.repository.IngredientDao;
import com.project.springboost.repository.RecipeDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeDao recipeRepository;

    @Autowired
    private IngredientDao ingredientRepository;

    public List<Recipe> getRecipes() {
        Iterable<Recipe> recipeIterable = recipeRepository.findAll();
        List<Recipe> recipeList = new ArrayList<>();
        recipeIterable.forEach(recipeList::add);
        return recipeList;
    }

    @Transactional
    public Recipe saveRecipe(Recipe recipe) {
        // Set the recipe for each ingredient
        for (Ingredient ingredient : recipe.getIngredients()) {
            ingredient.setRecipe(recipe);
        }
        for (Tool tool : recipe.getTools()) {
            tool.setRecipe(recipe);
        }
        return recipeRepository.save(recipe);
    }
}