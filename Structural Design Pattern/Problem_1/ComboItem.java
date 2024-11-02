import java.util.ArrayList;
import java.util.List;

public class ComboItem implements RestaurantInterface{
    private String ComboName;
    private List<RestaurantInterface> foodItemList = new ArrayList<>();
    private List<RestaurantInterface> FreeItemList = new ArrayList<>();
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

    public void addFreeItem(RestaurantInterface FoodItem) {
        FreeItemList.add(FoodItem);
    }

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
        System.out.println(ComboName + ": ");
        for(RestaurantInterface combo: foodItemList) {
            combo.menuDetails();
        }

        System.out.println("Free Items:-");
        for(RestaurantInterface freeItem: FreeItemList) {
            freeItem.menuDetails();
        }

        System.out.println("Discount " + discountAmount +"%");

    }
    
}
