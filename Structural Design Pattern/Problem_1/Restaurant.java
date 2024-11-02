import java.util.ArrayList;
import java.util.List;

public class Restaurant implements RestaurantInterface{
    @SuppressWarnings("unused")
    private String restaurantName;
    private List<RestaurantInterface> comboList = new ArrayList<>();
    private List<RestaurantInterface> FoodList = new ArrayList<>();

    Restaurant(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public void addFood(RestaurantInterface food) {
        FoodList.add(food);
    } 

    public void addCombo(RestaurantInterface combo) {
        comboList.add(combo);
    }

    public List<RestaurantInterface> getComboList() {
        return comboList;
    }

    public List<RestaurantInterface> getFoodList() {
        return FoodList;
    }

    public void menuDetails() {
        System.out.println("Menu:");
        for(RestaurantInterface food: FoodList) {
            food.menuDetails();
        }

        for(RestaurantInterface combo: comboList) {
            combo.menuDetails();
        }
    }
    
}
