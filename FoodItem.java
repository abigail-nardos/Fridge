import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class FoodItem {
    public String name;
    public String category;
    public Date expirationDate;

    public FoodItem() {
        name = "";
        category = "";
        expirationDate = new Date();
    }
    public FoodItem(String name, String category, Date expirationDate) {
        this.name = name;
        this.category = category;
        this.expirationDate = expirationDate;
    }

    public boolean isExpired() {
        Date date = new Date();
        if (expirationDate.before(date)) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void categoryScanner(String categories) {
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        String inputCategory = "";
        while (!valid) {
            System.out.print("please enter a valid food category: ");
            inputCategory = scanner.nextLine();
            switch (inputCategory) {
                case "fruit", "vegetable", "dairy", "protein", "grains", "condiment" -> {
                    valid = true;
                    this.category = inputCategory;
                }
            }
        }
    }
    public void setCategory(String category) {
        this.category = category; //issue using category scanner
        /*String categories = "fruit vegetable dairy protein grains";
        if (categories.contains(category)) {
            this.category = category;
        }
        else {
            categoryScanner(categories);
        }*/
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        String str = formatter.format(expirationDate);
        return name + ", " + category + ", " + ", " + str;

    }

}
