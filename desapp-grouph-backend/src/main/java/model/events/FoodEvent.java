package model.events;

import model.users.FoodType;
import model.users.Profile;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="FoodEvent")
public class FoodEvent extends EventType{

    @ElementCollection(targetClass = FoodType.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<FoodType> foodTypes = new ArrayList<>();

    @Override
    public boolean compareTo(Profile profile) {
        return foodTypes.stream().anyMatch(foodType -> profile.likeFoodType(foodType));
    }

    public void addFoodType(FoodType foodType){
        foodTypes.add(foodType);
    }

    @Override
    public boolean possiblyLikes(Profile profile) {
        return (foodTypes.stream()
                .anyMatch(foodType -> profile.likeFoodType(foodType)))
                ||
                profile.likeManyFoodTypes();
    }
}
