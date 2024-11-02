import java.util.List;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant("ECE Canteen");

        FoodItem foodItem1 = new FoodItem("Burger" , 300);
        FoodItem foodItem2 = new FoodItem("Fries" , 100);
        FoodItem foodItem3 = new FoodItem("Wedges" , 150);
        FoodItem foodItem4 = new FoodItem("Shawarma" , 200);
        FoodItem foodItem5 = new FoodItem("Drink" , 25);

        restaurant.addFood(foodItem1);
        restaurant.addFood(foodItem2);
        restaurant.addFood(foodItem3);
        restaurant.addFood(foodItem4);
        restaurant.addFood(foodItem5);

        ComboItem comboItem1 = new ComboItem("Combo1");
        comboItem1.addFoodItem(foodItem1);
        comboItem1.addFoodItem(foodItem2);
        comboItem1.addFoodItem(foodItem5);

        ComboItem comboItem2 = new ComboItem("Combo2");
        comboItem2.addFoodItem(foodItem4);
        comboItem2.addFoodItem(foodItem5);

        restaurant.addCombo(comboItem1);
        restaurant.addCombo(comboItem2);
        
        List<RestaurantInterface> foodList = restaurant.getFoodList();
        List<RestaurantInterface> comboList = restaurant.getComboList();

        while (true) {
            System.out.println("Press 1 to create a combo, 2 to view menu and 0 to exit.");

            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();

            if(number == 0) {
                break;
            }

            else if(number == 1) {
                System.out.print("Enter the name of the combo: ");
                String comboname = scanner.nextLine();
                ComboItem combo = new ComboItem(comboname);

                while(true) {
                    System.out.println("Available Commands: ");
                    System.out.println("1.Add[item]");
                    System.out.println("2.Remove[item]");
                    System.out.println("3.Free[item]");
                    System.out.println("4.Discount[percentage]");
                    System.out.println("5.Done");

                    System.out.print("Press between 1 to 5: ");

                    int commandNum = scanner.nextInt();

                    if(commandNum == 1) {
                        System.out.print("Add ");
                        String item = scanner.nextLine();

                        for(RestaurantInterface food: foodList) {
                            if(((FoodItem)food).getFoodName().equals(item)) {
                                combo.addFoodItem(food);
                                break;
                            }
                        }

                        for(RestaurantInterface comboItem: comboList) {
                            if(((ComboItem)comboItem).getComboName().equals(item)) {
                                combo.addFoodItem(comboItem);
                                break;
                            }
                        }
                        
                    }

                    if(commandNum == 2) {
                        String item = scanner.nextLine();

                        for(RestaurantInterface comboItem: combo.getFoodList()) {
                            if(((ComboItem)comboItem).getComboName().equals(item)) {
                                combo.removeFoodItem(comboItem);
                                break;
                            }
                        }
                    }

                    if(commandNum == 3) {
                        String item = scanner.nextLine();
                        for(RestaurantInterface food: foodList) {
                            if(((FoodItem)food).getFoodName().equals(item)) {
                                combo.addFoodItem(food);
                                break;
                            }
                        }
                    }

                    if(commandNum == 4) {
                        int amount = scanner.nextInt();
                        combo.setDiscount(amount);
                    }

                    if(commandNum == 5) {
                        restaurant.addCombo(combo);
                    }
                }
            }

            else if(number == 2) {
                for(RestaurantInterface food: foodList) {
                    food.menuDetails();
                }

                for(RestaurantInterface combo: comboList) {
                    combo.menuDetails();
                }
            }
            
            scanner.close();
        }



    }
}
