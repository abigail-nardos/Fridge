import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import static java.lang.Math.min;


public class Fridge {

    //list of FoodItem's in Fridge
    private FoodItem[] foodList;

    //list of Recipe's in Fridge's database
    private Recipe[] recipeList;

    //number of FoodItem's in Fridge
    private int numFood;

    //number of Recipe's in Fridge
    private int numRecipe;

    //setting INITIAL_SIZE of foodList and recipeList
    private static int INITIAL_SIZE = 50;


    public Fridge() {
	foodList = new FoodItem[INITIAL_SIZE];
	recipeList = new Recipe[INITIAL_SIZE];
        numFood = 0;
        numRecipe = 0;
    }

    //returns a string of FoodItem names in Fridge
    public String getFoodList() {
        String food = "";
        for (int i=0; i<numFood-1; i++) {
            food += foodList[i].getName() + "\n";
        }
        food += foodList[numFood-1].getName();
        return food;
    }

    //returns a string of Recipe's in Fridge's database
    public String getRecipeList() {
        String recipe = "";
        for (int i=0; i<numRecipe-1; i++) {
            recipe += recipeList[i].getName() + '\n';
        }
        recipe += recipeList[numRecipe - 1].getName();
        return recipe;
    }

    //removes all expired food from Fridge
    public void removeExpired() {
        for (int i=0; i<numFood; i++) {
            if (foodList[i].isExpired()) {
                fRemoveAndShift(i);
                i--;
            }
        }
    }

    //adds recipe to Fridge's recipeList
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

    //returns boolean if recipe is in Fridge's recipeList
    public boolean isRecipePresent(Recipe recipe) {
        for (int i=0; i<numRecipe; i++) {
            if (recipeList[i] == recipe) {
                return true;
            }
        }
        return false;
    }

    //remove's recipe from Fridge's recipeList
    public void removeRecipe(Recipe recipe) {
        for (int i=0; i<numRecipe; i++) {
            if (recipeList[i] == recipe) {
                rRemoveAndShift(i);
                numRecipe--;
            }
        }
    }

    //adds food to Fridge's foodList
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
    
    //adds list of food to Fridge's foodList
    public void addFood(FoodItem[] food) {
        for (int i=0; i<food.length; i++) {
            addFood(food[i]);
        }
    }

    //removes food from Fridge's foodList
    public void removeFood(FoodItem food) {
        removeFood(food.getName());
    }

    //helper function to remove food name from Fridge's foodList
    public void removeFood(String name) {
        for (int i=0; i<numFood; i++) {
            if (foodList[i].getName().equals(name)) {
                fRemoveAndShift(i);
                i--;
            }
        }
    }

    //removes all food in category from Fridge's foodList
    public void removeCategory(String category) {
        for (int i=0; i<numFood; i++) {
            if (foodList[i].getCategory().equals(category)) {
                fRemoveAndShift(i);
                i--;
            }
        }
    }

    //returns a string of food expiring within days
    public String expiringFood(int days) {
        FoodItem[] expiringFood = new FoodItem[numFood];
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
        String str = "";
        for (int i=0; i<position-1; i++) {
            str += expiringFood[i].getName() + ", ";
        }
        str += expiringFood[position-1].getName();
        return str;
    }

    //returns a boolean if FoodItem food is in Fridge's foodList
    public boolean isFoodPresent(FoodItem food) {
        for (int i=0; i<numFood; i++) {
            if (foodList[i].equals(food)) {
                return true;
            }
        }
        return false;
    }

    //returns a boolean if food name is in Fridge's foodList
    public boolean isFoodPresent(String name) {
        for (int i=0; i<numFood; i++) {
            if (foodList[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    //returns a boolean if list of groceries is in Fridge's foodList
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

    //takes a list of food items as a parameter (a grocery list)
    //returns a string of food items from the grocery list that are in the fridge
    public String isGroceryListPresent(FoodItem[] groceries) {
        int length = min(groceries.length, numFood);
        int position = 0;
        FoodItem[] tmp = new FoodItem[length];
        for (int i=0; i<length; i++) {
            if (isFoodPresent(groceries[i].getName()) == true) {
                tmp[position] = groceries[i];
                position++;
            }
        }
        String str = "";
        for (int i=0; i<position-1; i++) {
            str += tmp[i].getName() + " ";
        }
        str += tmp[position-1].getName();
        return str;
    }

    //helper function to remove item in foodList at position and shift list left
    private void fRemoveAndShift(int position) {
        for (int i=position; i<numFood-1; i++) {
            foodList[i] = foodList[i+1];
        }
        numFood--;
    }

    //helper function to expand foodList
    private void fExpandAndCopy() {
        FoodItem[] tmp = new FoodItem[foodList.length*2];
        for (int i=0; i<numFood; i++) {
            tmp[i] = foodList[i];
        }
        foodList = tmp;
    }

    //helper function to remove recipe in recipeList at position and shift list left
    private void rRemoveAndShift(int position) {
        for (int i=position; i<numRecipe-1; i++) {
            recipeList[i] = recipeList[i+1];
        }
    }

    //helper function to expand recipeList
    private void rExpandAndCopy() {
        Recipe[] tmp = new Recipe[recipeList.length*2];
        for (int i=0; i<numRecipe; i++) {
            tmp[i] = recipeList[i];
        }
        recipeList = tmp;
    }

    //creates string of Fridge
    public String toString() {
        String str = "";
        str += "Food: " + "\n";

        for (int i=0; i<numFood; i++) {
            str += foodList[i] + "\n";
        }
        str += "Recipes: " + "\n";

        for (int i=0; i<numRecipe-1; i++) {
            str += recipeList[i] + "\n";
        }
        str += recipeList[numRecipe-1];
        return str;
    }
}

