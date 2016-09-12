package model;

import model.events.FoodEvent;
import model.users.FoodType;
import model.users.Profile;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FoodEventTest {

    @Test
    public void shouldCompareAnEventWithAProfile(){
        Profile mockedProfile = mock(Profile.class);
        FoodEvent foodEvent = new FoodEvent();
        foodEvent.addFoodType(FoodType.PASTA);
        foodEvent.addFoodType(FoodType.PIZZA);
        foodEvent.addFoodType(FoodType.VEGAN);

        when(mockedProfile.likeFoodType(FoodType.VEGAN)).thenReturn(true);
        when(mockedProfile.likeFoodType(FoodType.PIZZA)).thenReturn(false);
        when(mockedProfile.likeFoodType(FoodType.PASTA)).thenReturn(false);

        assertTrue(foodEvent.compareTo(mockedProfile));
        verify(mockedProfile).likeFoodType(FoodType.PASTA);
        verify(mockedProfile).likeFoodType(FoodType.VEGAN);
        verify(mockedProfile).likeFoodType(FoodType.PIZZA);
    }
}
