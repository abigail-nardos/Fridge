public class Recipe {
	
	//Recipe name
	private String name;

	//Recipe ingredients made of a list of FoodItem's
	private FoodItem[] ingredients;

	//Recipe instructions
	private String instructions;
	
	//number of ingredients used in Recipe
	private int numIngredients;

	//setting INITIAL_SIZE of ingredients list
        private static int INITIAL_SIZE = 20;


        public Recipe() {
            name = "";
            ingredients = new FoodItem[INITIAL_SIZE];
            numIngredients = 0;
        }


        public Recipe(String name, FoodItem[] ingredients, String instructions) {
            this.name = name;
            this.ingredients = ingredients;
        }

	//returns Recipe's name
        public String getName() {
                return name;
        }

	//returns Recipe's ingredients
        public FoodItem[] getIngredients() {
        	return ingredients;
	}

	//returns Recipe's instructions
        public String getInstructions() {
		return instructions; 
	}

	//returns Recipe's number of ingredients
        public int getNumIngredients() {
        	return numIngredients;
    	}

	 //sets Recipe's name to name
        public void setName(String name) {
                this.name = name;
        }

	//sets Recipe's ingredients to ingredients
        public void setIngredients(FoodItem[] ingredients) {
            for (int i=0; i<ingredients.length; i++) {
                add(ingredients[i]);
            }
    	}

	//sets Recipe's instructions to instructions
        public void setInstructions(String instructions) {
		this.instructions = instructions; 
	}

	//helper function to expand Recipe's ingredients list
        private void expandAndCopy() {
            FoodItem[] tmp = new FoodItem[ingredients.length*2];
            for (int i=0; i<numIngredients; i++) {
                tmp[i] = ingredients[i];
            }
            ingredients = tmp;
        }

	//removes FoodItem f from ingredients list
        public void remove(FoodItem f) {
            String name = f.getName();
            remove(name);
        }

	//helper function for remove with FoodItem parameter
        public void remove(String name) {
            if (numIngredients >= ingredients.length) {
                expandAndCopy();
            }
            for (int i=0; i<numIngredients; i++) {
                if (ingredients[i].getName().equals(name)) {
                    removeAndShift(i);
                }
            }
        }

	//adds FoodItem f to ingredients list
        public void add(FoodItem f) {
            if (numIngredients >= ingredients.length) {
                expandAndCopy();
            } else {
                ingredients[numIngredients] = f;
                numIngredients++;
            }
        }

	//helper function to remove ingredient at position and shift list left
        private void removeAndShift(int position) {
            for (int i=position; i<=numIngredients-1; i++) {
                ingredients[i] = ingredients[i+1];
            }
            numIngredients--;
        }

	//creates string of Recipe
        public String toString() {
            String s = name + "\n" + "Ingredients: ";
            for (int i=0; i<numIngredients-1; i++) {
                s += ingredients[i].getName() + ", ";
            }
            s += ingredients[numIngredients-1].getName();
            s += "\n" + "Instructions: " + instructions;
            return s;
        }
    }
