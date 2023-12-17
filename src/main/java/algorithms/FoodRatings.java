package algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class FoodRatings {

    private final Map<String, Integer> foodRating = new HashMap<>();
    private final Map<String, PriorityQueue<Food>> cuisinesFood = new HashMap<>();

    private final Map<String, String> foodCuisines = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodRating.put(food, rating);
            foodCuisines.put(food, cuisine);
            cuisinesFood.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>()).add(new Food(foods[i], ratings[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        foodRating.put(food, newRating);

        String cuisine = foodCuisines.get(food);

        if (cuisine != null) {
            cuisinesFood.get(cuisine).add(new Food(food, newRating));
        }
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Food> foods = cuisinesFood.get(cuisine);
        var food = foods.peek();
        while (!food.rating.equals(foodRating.get(food.foodName))) {
            foods.poll();
            food = foods.peek();
        }
        return food.foodName;
    }

    static class Food implements Comparable<Food> {
        private String foodName;
        private Integer rating;

        public Food(String foodName, Integer rating) {
            this.foodName = foodName;
            this.rating = rating;
        }


        @Override
        public int compareTo(Food food) {
            if (Objects.equals(rating, food.rating)) {
                return foodName.compareTo(food.foodName);
            }
            return -1 * Integer.compare(rating, food.rating);
        }
    }
}
