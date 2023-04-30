import java.util.Date;

public class Tester {
    public static void main(String[] args) {
        Date d = new Date();
        FoodItem onions = new FoodItem("onion","vegetable",d);
        FoodItem garlic = new FoodItem("garlic","vegetable",d);
        FoodItem potatoes = new FoodItem("potato","vegetable",d);
        FoodItem lettuce = new FoodItem("lettuce","vegetable",d);
        FoodItem pepper = new FoodItem("pepper","vegetable",d);

        FoodItem cheese = new FoodItem("cheese","dairy",d);
        FoodItem yogurt = new FoodItem("yogurt","dairy",d);
        FoodItem butter = new FoodItem("butter","dairy",d);
        FoodItem eggs = new FoodItem("eggs","dairy",d);

        FoodItem beef = new FoodItem("ground beef","protein",d);
        FoodItem chicken = new FoodItem("chicken","protein",d);

        FoodItem bread = new FoodItem("bread","grains",d);
        FoodItem pasta = new FoodItem("pasta","grains",d);
        FoodItem rice = new FoodItem("rice","grains",d);

        FoodItem tomatoes = new FoodItem("tomato","fruit",d);
        FoodItem banana = new FoodItem("banana","fruit",d);
        FoodItem apples = new FoodItem("apple","fruit",d);
        FoodItem strawberries = new FoodItem("strawberry","fruit",d);

        FoodItem mayo = new FoodItem("mayo","condiment",d);
        FoodItem mustard = new FoodItem("mustard","condiment",d);
        FoodItem hotSauce = new FoodItem("hot sauce","condiment",d);
        FoodItem ketchup = new FoodItem("ketchup","condiment",d);

        FoodItem[] vegetables = {onions,garlic,potatoes,lettuce,pepper};
        FoodItem[] dairy = {cheese,yogurt,butter,eggs};
        FoodItem[] fruits = {tomatoes,banana,apples,strawberries};
        FoodItem[] protein = {chicken,beef};
        FoodItem[] condiments = {mayo,mustard,hotSauce,ketchup};
        FoodItem[] grains = {bread,pasta,rice};

        Fridge smartFridge = new Fridge();
        smartFridge.addFood(vegetables);
        smartFridge.addFood(dairy);
        smartFridge.addFood(fruits);
        smartFridge.addFood(protein);
        smartFridge.addFood(condiments);
        smartFridge.addFood(grains);

        String foodList = smartFridge.getFoodList();
        System.out.println(foodList);
    }
}
