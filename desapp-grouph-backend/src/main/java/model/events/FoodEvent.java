package model.events;

import model.FoodType;
import model.Profile;

import java.util.ArrayList;
import java.util.List;

public class FoodEvent extends EventType{

    private List<FoodType> foodTypes = new ArrayList<FoodType>();

    @Override
    public boolean compareTo(Profile profile) {
        return foodTypes.stream().anyMatch(foodType -> profile.likeFoodType(foodType));
    }

    public void addFoodType(FoodType foodType){
        foodTypes.add(foodType);
    }
}
