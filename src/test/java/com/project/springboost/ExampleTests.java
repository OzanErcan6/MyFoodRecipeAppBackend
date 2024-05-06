package com.project.springboost;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.springboost.entity.Ingredient;
import com.project.springboost.entity.Recipe;
import com.project.springboost.repository.IngredientDao;
import com.project.springboost.repository.RecipeDao;
import com.project.springboost.service.RecipeService;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestPropertySource("/application-test.properties")
@AutoConfigureMockMvc
@SpringBootTest
public class ExampleTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private RecipeDao recipeRepository;

    @Autowired
    private IngredientDao ingredientDao;

    @Autowired
    EntityManager entityManager;

    @Autowired
    RecipeService recipeService;

//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }


    @Test
    @Transactional
    public void testSaveRecipeAndIngredients() {
        // Create a Recipe
        Recipe recipe = new Recipe();
        recipe.setName("Pasta Carbonara");

        // Create Ingredients
        Ingredient pasta = new Ingredient();
        pasta.setName("Pasta");
        pasta.setAmount("200"); // grams
        pasta.setMeasureType("grams"); // Set unit
        pasta.setRecipe(recipe);
        recipe.addIngredients(pasta);

        Ingredient bacon = new Ingredient();
        bacon.setName("Bacon");
        bacon.setAmount("100"); // grams
        bacon.setMeasureType("grams"); // Set unit
        bacon.setRecipe(recipe);
        recipe.addIngredients(bacon);

        recipeService.saveRecipe(recipe);

        // Check if Recipe is saved
        assertNotNull(recipe.getId());

        // Check if Ingredients are saved
        assertNotNull(pasta.getId());
        assertNotNull(bacon.getId());

        // Retrieve Recipe from database
        Recipe savedRecipe = recipeRepository.findById(Math.toIntExact(recipe.getId())).orElse(null);

        // Check if retrieved Recipe is not null
        assertNotNull(savedRecipe);

        // Check if retrieved Recipe has correct name
        assertEquals("Pasta Carbonara", savedRecipe.getName());

        // Check if retrieved Recipe has correct number of Ingredients

    }



}
