package model.builders;

import model.events.FoodEvent;
import model.users.FoodType;

import java.util.ArrayList;
import java.util.List;


public class FoodEventBuilder {

    private List<FoodType> foodTypes;

    public FoodEventBuilder() {
        this.foodTypes = new ArrayList<>();
    }

    public static FoodEventBuilder anyFoodEvent() {
        return new FoodEventBuilder();
    }

    public FoodEvent build() {
        FoodEvent foodEvent = new FoodEvent();
        foodEvent.setFoodTypes(this.foodTypes);
        return foodEvent;
    }
}
