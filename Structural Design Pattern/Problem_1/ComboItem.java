import java.util.ArrayList;
import java.util.List;

public class ComboItem implements RestaurantInterface{
    private String ComboName;
    private List<RestaurantInterface> foodItemList = new ArrayList<>();
    // private List<RestaurantInterface> FreeItemList = new ArrayList<>();
    private int discountAmount = 0;
    

    public ComboItem(String ComboName) {
        this.ComboName = ComboName;
    }

    public void addFoodItem(RestaurantInterface FoodItem) {
        foodItemList.add(FoodItem);
    }

    public void removeFoodItem(RestaurantInterface FoodItem) {
        foodItemList.remove(FoodItem);
    }

    // public void addFreeItem(RestaurantInterface FoodItem) {
    //     FreeItemList.add(FoodItem);
    // }

    public void applyDiscount(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public void setDiscount(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getComboName() {
        return ComboName;
    }

    public List<RestaurantInterface> getFoodList() {
        return foodItemList;
    }

    public void menuDetails() {
        System.out.println(ComboName + ":- ");

        for(RestaurantInterface combo: foodItemList) {
            combo.menuDetails();
        }
        
        int totalCost = getCost();

        System.out.println("Total Cost: " + totalCost);

        if(discountAmount > 0) {
            System.out.println("Discount " + discountAmount +"%");
            System.out.println("Discounted Cost: " + (totalCost - (totalCost * discountAmount / 100)));
        }
    }

    public int getCost() {

        int totalCost = 0;
        for(RestaurantInterface combo: foodItemList) {
            totalCost += combo.getCost();
        }

        return totalCost;
    }
    
}
