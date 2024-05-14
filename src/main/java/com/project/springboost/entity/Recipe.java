package com.project.springboost.entity;


import com.project.springboost.entity.enums.Difficulty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ingredient> ingredients = new ArrayList<>();

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Tool> tools = new ArrayList<>();

    private String description;

    @ElementCollection
    @CollectionTable(name = "recipe_instructions", joinColumns = @JoinColumn(name = "recipe_id"))
    @Column(name = "instruction")
    @OrderColumn
    private List<String> instructions = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    private int prepTime;

    private int numberOfServings;

    private String imageUrl;

    private String notes;

    public Recipe() {
    }

    public Recipe(String name, List<Ingredient> ingredients, List<Tool> tools, String description,
                  List<String> instructions, Difficulty difficulty, int prepTime, int numberOfServings,
                  String imageUrl, String notes) {
        this.name = name;
        this.ingredients = ingredients;
        this.tools = tools;
        this.description = description;
        this.instructions = instructions;
        this.difficulty = difficulty;
        this.prepTime = prepTime;
        this.numberOfServings = numberOfServings;
        this.imageUrl = imageUrl;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addIngredients(Ingredient ingredients) {
        this.ingredients.add(ingredients);
    }

    public List<Tool> getTools() {
        return tools;
    }

    public void addTool(Tool tool) {
        this.tools.add(tool);
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public int getNumberOfServings() {
        return numberOfServings;
    }

    public void setNumberOfServings(int numberOfServings) {
        this.numberOfServings = numberOfServings;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}