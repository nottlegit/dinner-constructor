package ru.practicum.dinner;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> informationAboutDishes = new HashMap<>();
    Random random = new Random();

    public void addDish(String dishType, String dishName) {
        if (!informationAboutDishes.containsKey(dishType)) {
            ArrayList<String> listDishes = new ArrayList<>();

            listDishes.add(dishName);
            informationAboutDishes.put(dishType, listDishes);
        } else {
            informationAboutDishes.get(dishType).add(dishName);
        }

    }

    public void generateDishCombo(int numberOfCombos, ArrayList<String> listOfTypesOfDishes) {
        for (int i = 1; i <= numberOfCombos; i++) {
            ArrayList<String> listOfCombos = new ArrayList<>();
            for (String category : listOfTypesOfDishes) {
                int sizeOfTheResultingList = informationAboutDishes.get(category).size();
                int randomIndexList = random.nextInt(sizeOfTheResultingList);
                String dishFromCategory = informationAboutDishes.get(category).get(randomIndexList);
                listOfCombos.add(dishFromCategory);
            }
            System.out.println("Комбо" + i);
            System.out.println(listOfCombos);
        }
    }

    public boolean isTypeDishesInHashMap(String category) {
        return informationAboutDishes.containsKey(category);
    }
}
