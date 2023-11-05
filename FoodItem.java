import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class FoodItem {

    //e.g. tomato, milk
    public String name;

    //e.g. vegetable, protein, grain
    public String category;

    //date FoodItem is expiring
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

    //returns FoodItem's name
    public String getName() {
        return name;
    }

    //returns FoodItem's category
    public String getCategory() {
        return category;
    }

    //returns FoodItem's expiration date
    public Date getExpirationDate() {
        return expirationDate;
    }

    //sets FoodItem's name to name
    public void setName(String name) {
        this.name = name;
    }

    //sets FoodItem's category to category
    public void setCategory(String category) {
        this.category = category;
    }

    //sets FoodItem's expiration date to exiprationDate
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }


    //returns boolean if FoodItem is expired
    public boolean isExpired() {
        Date date = new Date();
        if (expirationDate.before(date)) {
            return true;
        }
        return false;
    }

    //creates string of FoodItem
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        String str = formatter.format(expirationDate);
        return category + ": " + name + ", " + "Due: " + str;

    }
}
