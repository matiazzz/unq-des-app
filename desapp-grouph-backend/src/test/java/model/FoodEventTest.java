package model;

import model.events.FoodEvent;
import model.users.Profile;
import org.junit.Test;
import static model.users.FoodType.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FoodEventTest {

    @Test
    public void shouldCompareAnEventWithAProfile(){
        Profile mockedProfile = mock(Profile.class);
        FoodEvent foodEvent = new FoodEvent();
        foodEvent.addFoodType(PASTA);
        foodEvent.addFoodType(PIZZA);
        foodEvent.addFoodType(VEGAN);

        when(mockedProfile.likeFoodType(VEGAN)).thenReturn(true);
        when(mockedProfile.likeFoodType(PIZZA)).thenReturn(false);
        when(mockedProfile.likeFoodType(PASTA)).thenReturn(false);

        assertTrue(foodEvent.compareTo(mockedProfile));
        verify(mockedProfile).likeFoodType(PASTA);
        verify(mockedProfile).likeFoodType(VEGAN);
        verify(mockedProfile).likeFoodType(PIZZA);
    }

    @Test
    public void shouldPossiblyLikeAFoodEventWhenLikeAtLeastAFoodType(){
        FoodEvent foodEvent = new FoodEvent();
        foodEvent.addFoodType(CHINESE);
        foodEvent.addFoodType(PASTA);
        foodEvent.addFoodType(ITALIAN);
        foodEvent.addFoodType(VEGAN);
        Profile profile = mock(Profile.class);
        when(profile.likeFoodType(CHINESE)).thenReturn(true);
        assertTrue(foodEvent.possiblyLikes(profile));
    }

    @Test
    public void shouldPossiblyLikeAFoodEventWhenLikeManyFoodTypes(){
        FoodEvent foodEvent = new FoodEvent();
        Profile profile = mock(Profile.class);
        when(profile.likeManyFoodTypes()).thenReturn(true);
        assertTrue(foodEvent.possiblyLikes(profile));
    }

    @Test
    public void shouldDontPossiblyLikeAFoodEvent(){
        FoodEvent foodEvent = new FoodEvent();
        foodEvent.addFoodType(CHINESE);
        foodEvent.addFoodType(PASTA);
        foodEvent.addFoodType(ITALIAN);
        Profile profile = mock(Profile.class);
        when(profile.likeManyFoodTypes()).thenReturn(false);
        when(profile.likeFoodType(CHINESE)).thenReturn(false);
        when(profile.likeFoodType(PASTA)).thenReturn(false);
        when(profile.likeFoodType(ITALIAN)).thenReturn(false);
        assertFalse(foodEvent.possiblyLikes(profile));
    }
}
