package model.events;

import model.users.FoodType;
import model.users.Profile;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="FoodEvent")
@PrimaryKeyJoinColumn(name="id")
public class FoodEvent extends EventType {

    @ElementCollection(targetClass = FoodType.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    private List<FoodType> foodTypes = new ArrayList<>();

    public FoodEvent(List<FoodType> foodTypes) {
        this.foodTypes = foodTypes;
    }

    public FoodEvent() {}

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

    public List<FoodType> getFoodTypes() {
        return foodTypes;
    }

    public void setFoodTypes(List<FoodType> foodTypes) {
        this.foodTypes = foodTypes;
    }
}
