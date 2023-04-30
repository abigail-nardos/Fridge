public class Recipe {
        private static int INITIAL_SIZE = 20;
        private FoodItem[] ingredients;
        private String name;
        private int numIngredients;

        public Recipe() {
            name = "";
            ingredients = new FoodItem[INITIAL_SIZE];
            numIngredients = 0;
        }
        public Recipe(String name, FoodItem[] ingredients) {
            this.name = name;
            this.ingredients = ingredients;
        }

        private void expandAndCopy() {
            FoodItem[] tmp = new FoodItem[ingredients.length*2];
            for (int i=0; i<numIngredients; i++) {
                tmp[i] = ingredients[i];
            }
            ingredients = tmp;
        }

        private void removeAndShift(int position) {
            for (int i=position; i<numIngredients-1; i++) {
                ingredients[i+1] = ingredients[i];
            }
        }

        public void remove(FoodItem f) {
            String name = f.getName();
            remove(name);
        }

        public void remove(String name) {
            if (numIngredients >= ingredients.length) {
                expandAndCopy();
            }
            for (int i=0; i<numIngredients; i++) {
                if (ingredients[i].getName().equals(name)) {
                    removeAndShift(i);
                    numIngredients--;
                }
            }
        }

        public void add(FoodItem f) {
            if (numIngredients >= ingredients.length) {
                expandAndCopy();
            } else {
                ingredients[numIngredients] = f;
                numIngredients++;
            }
        }

        public void setIngredients(FoodItem[] ingredients) {
            this.ingredients = ingredients;
        }

        public void setName(String name) {
            this.name = name;
        }

        public FoodItem[] getIngredients() {
            return ingredients;
        }

        public String getName() {
            return name;
        }

        public int getNumIngredients() {
            return numIngredients;
        }

        public String toString() {
            String s = name + "\n" + "Ingredients: ";
            for (int i=0; i<numIngredients-1; i++) {
                s += ingredients[i].getName() + ", ";
            }
            s += ingredients[numIngredients-1].getName();
            return s;
        }
    }
