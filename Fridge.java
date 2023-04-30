import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.lang.Math.min;

public class Fridge {
    public static int INITIAL_SIZE = 10;
    public FoodItem[] foodList = new FoodItem[INITIAL_SIZE];
    public Recipe[] recipeList = new Recipe[INITIAL_SIZE];
    public int numFood;
    public int numRecipe;

    public Fridge() {
        numFood = 0;
        numRecipe = 0;
    }


    public String getFoodList() {
        String food = "";
        for (int i=0; i<numFood; i++) {
            food += foodList[i];
        }
        return food;
    }

    public void removeExpired() {
        for (int i=0; i<numFood; i++) {
            if (foodList[i].isExpired()) {
                fRemoveAndShift(i);
                numFood--;
            }
        }
    }


    public Recipe[] recipeOptions() {
        Recipe[] tmp = new Recipe[numRecipe];
        int position = 0;
        for (int i=0; i<numRecipe; i++) {
            FoodItem[] ingredients = recipeList[i].getIngredients();
            if (isFoodListPresent(ingredients)) {
                tmp[position] = recipeList[i];
                position++;
            }
        }
        return tmp;
    }


    public void addRecipe(Recipe recipe) {
        if (!isRecipePresent(recipe)) {
            if (numRecipe >= recipeList.length) {
                rExpandAndCopy();
            }
            else {
                recipeList[numRecipe] = recipe;
                numRecipe++;
            }
        }
    }


    public boolean isRecipePresent(Recipe recipe) {
        for (int i=0; i<numRecipe; i++) {
            if (recipeList[i] == recipe) {
                return true;
            }
        }
        return false;
    }


    public void removeRecipe(Recipe recipe) {
        for (int i=0; i<numRecipe; i++) {
            if (recipeList[i] == recipe) {
                rRemoveAndShift(i);
                numRecipe--;
            }
        }
    }


    public void addFood(FoodItem food) {
        if (!isFoodPresent(food)) {
            if (numFood >= foodList.length) {
                fExpandAndCopy();
            }
            else {
                foodList[numFood] = food;
                numFood++;
            }
        }
    }

    public void addFood(FoodItem[] food) {
        for (int i=0; i<food.length; i++) {
            addFood(food[i]);
        }
    }

    public void removeFood(FoodItem food) {
        removeFood(food.getName());
    }


    public void removeFood(String name) {
        for (int i=0; i<numFood; i++) {
            if (foodList[i].getName().equals(name)) {
                fRemoveAndShift(i);
                numFood--;
            }
        }
    }


    public void removeCategory(String category) {
        for (int i=0; i<numFood; i++) {
            if (foodList[i].getCategory().equals(category)) {
                fRemoveAndShift(i);
                numFood--;
            }
        }
    }


    public FoodItem[] expiringFood(int days) {
        FoodItem[] expiringFood = new FoodItem[numFood]; //change to exact number??
        int position = 0;
        Date today = new Date();
        Date daysFromToday = new Date(today.getTime());
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(daysFromToday);
        calendar.add(Calendar.DATE, days);
        daysFromToday.setTime(calendar.getTime().getTime());

        for (int i=0; i<numFood; i++) {
            if (foodList[i].getExpirationDate().before(daysFromToday)) {
                expiringFood[position] = foodList[i];
                position++;
            }
        }
        return expiringFood;
    }


    public boolean isFoodPresent(FoodItem food) {
        for (int i=0; i<numFood; i++) {
            if (foodList[i] == food) {
                return false;
            }
        }
        return true;
    }

    public boolean isFoodPresent(String name) {
        for (int i=0; i<numFood; i++) {
            if (foodList[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean isFoodListPresent(FoodItem[] groceries) {
        int length = min(groceries.length, numFood);
        int position = 0;
        FoodItem[] tmp = new FoodItem[length];
        for (int i=0; i<length; i++) {
            if (isFoodPresent(groceries[i].getName()) == false) {
                return false;
            }
        }
        return true;
    }


    public FoodItem[] isGroceryListPresent(FoodItem[] groceries) {
        int length = min(groceries.length, numFood);
        int position = 0;
        FoodItem[] tmp = new FoodItem[length];
        for (int i=0; i<length; i++) {
            if (isFoodPresent(groceries[i].getName()) == true) {
                tmp[position] = groceries[i];
            }
        }
        return tmp;
    }

    private void fRemoveAndShift(int position) {
        for (int i=position; i<numFood-1; i++) {
            foodList[i+1] = foodList[i];
        }
    }

    private void fExpandAndCopy() {
        FoodItem[] tmp = new FoodItem[foodList.length*2];
        for (int i=0; i<numFood; i++) {
            tmp[i] = foodList[i];
        }
        foodList = tmp;
    }

    private void rRemoveAndShift(int position) {
        for (int i=position; i<numRecipe-1; i++) {
            recipeList[i] = recipeList[i+1];
        }
    }

    private void rExpandAndCopy() {
        Recipe[] tmp = new Recipe[recipeList.length*2];
        for (int i=0; i<numRecipe; i++) {
            tmp[i] = recipeList[i];
        }
        recipeList = tmp;
    }
}
