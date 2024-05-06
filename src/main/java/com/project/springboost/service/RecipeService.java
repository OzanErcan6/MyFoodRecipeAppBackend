package com.project.springboost.service;

import com.project.springboost.entity.Ingredient;
import com.project.springboost.entity.Recipe;
import com.project.springboost.repository.IngredientDao;
import com.project.springboost.repository.RecipeDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeDao recipeRepository;

    @Autowired
    private IngredientDao ingredientRepository;

    @Transactional
    public Recipe addRecipe(Recipe recipe) {
        for (Ingredient ingredient : recipe.getIngredients()) {
            ingredientRepository.save(ingredient);
        }

        // Save the recipe after the ingredients are saved
        return recipeRepository.save(recipe);
    }

    public List<Recipe> getRecipes() {
        return null;

    }

    public Recipe saveRecipe(Recipe recipe) {
        // Set the recipe for each ingredient
        for (Ingredient ingredient : recipe.getIngredients()) {
            ingredient.setRecipe(recipe);
        }
        return recipeRepository.save(recipe);
    }
}