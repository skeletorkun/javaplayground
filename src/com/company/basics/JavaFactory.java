package com.company.basics;


public class JavaFactory {

    interface Food {
        public String getType();
    }

    class Pizza implements Food {
        public String getType() {
            return "Someone ordered a Fast Food!";
        }
    }

    class Cake implements Food {

        public String getType() {
            return "Someone ordered a Dessert!";
        }
    }

    class FoodFactory {
        public Food getFood(String order) {

            if(order.equalsIgnoreCase("pizza")){
                return new Pizza();
            }
            else if(order.equalsIgnoreCase("cake")){
                return new Cake();
            }

            throw new RuntimeException("Unknown food");

        }//End of getFood method

    }

    public static void main(String[] args) {

    }
}