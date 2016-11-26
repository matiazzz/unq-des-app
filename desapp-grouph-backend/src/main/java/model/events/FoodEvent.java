package model.events;

import model.users.FoodType;
import model.users.Profile;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="FoodEvent")
@PrimaryKeyJoinColumn(name="id")
public class FoodEvent extends EventType {

    @ElementCollection(targetClass = FoodType.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    private Set<FoodType> foodTypes = new HashSet<>();

    public FoodEvent(Set<FoodType> foodTypes) {
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
}
