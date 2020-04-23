package com.example.pizzarecipes;

public class RecyclerViewItem {

    private int mainImageResource;
    private int timeImageResource;
    private String titleText;
    private String timeText;
    private String recipeShortText;
    private String recipeFullText;

    public RecyclerViewItem(int mainImageResource, int timeImageResource,
                            String titleText, String timeText, String recipeShortText, String recipeFullText) {
        this.mainImageResource = mainImageResource;
        this.timeImageResource = timeImageResource;
        this.titleText = titleText;
        this.timeText = timeText;
        this.recipeShortText = recipeShortText;
        this.recipeFullText = recipeFullText;
    }

    public int getMainImageResource() {
        return mainImageResource;
    }

    public int getTimeImageResource() {
        return timeImageResource;
    }

    public String getTitleText() {
        return titleText;
    }

    public String getTimeText() {
        return timeText;
    }

    public String getRecipeShortText() {
        return recipeShortText;
    }

    public String getRecipeFullText() {
        return recipeFullText;
    }
}
