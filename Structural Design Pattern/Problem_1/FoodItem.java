public class FoodItem implements RestaurantInterface{

    private String FoodItemName;
    private int FoodItemPrice;

    FoodItem(String FoodItemName, int FoodItemPrice) {
        this.FoodItemName = FoodItemName;
        this.FoodItemPrice = FoodItemPrice;
    }
    public void menuDetails() {
        if (FoodItemPrice == 0) {
            System.out.println(FoodItemName + " (Free!!!)");
        } else {
            System.out.println(FoodItemName + " - " + FoodItemPrice);
        }
    }

    public String getFoodName() {
        return FoodItemName;
    }

    public int getCost() {
        return FoodItemPrice;
    }
}
