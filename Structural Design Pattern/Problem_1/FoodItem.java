public class FoodItem implements RestaurantInterface{

    private String FoodItemName;
    private int FoodItemPrice;

    FoodItem(String FoodItemName, int FoodItemPrice) {
        this.FoodItemName = FoodItemName;
        this.FoodItemPrice = FoodItemPrice;
    }
    public void menuDetails() {
        System.out.println(FoodItemName + " - " + FoodItemPrice);
    }

    public String getFoodName() {
        return FoodItemName;
    }
}
