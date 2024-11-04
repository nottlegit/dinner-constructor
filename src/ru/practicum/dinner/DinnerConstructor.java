package ru.practicum.dinner;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> informationAboutDishes = new HashMap<>();
    Random random = new Random();

    public void addDish(String dishType, String dishName) {
        informationAboutDishes.computeIfAbsent(dishType, k -> new ArrayList<>()).add(dishName);
    }

    public void generateDishCombo(int numberOfCombos, ArrayList<String> listOfTypesOfDishes) {
        for (int i = 1; i <= numberOfCombos; i++) {
            ArrayList<String> listOfCombos = new ArrayList<>();
            for (String category : listOfTypesOfDishes) {
                ArrayList<String> dishes = informationAboutDishes.get(category);
                int sizeOfTheResultingList = dishes.size();
                int randomIndexList = random.nextInt(sizeOfTheResultingList);
                String dishFromCategory = dishes.get(randomIndexList);
                listOfCombos.add(dishFromCategory);
            }
            System.out.println("Комбо" + i);
            System.out.println(listOfCombos);
        }
    }

    public boolean existsDish(String category) {
        return informationAboutDishes.containsKey(category);
    }
}
