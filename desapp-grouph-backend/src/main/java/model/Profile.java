package model;

import java.util.ArrayList;
import java.util.List;

public class Profile {
    private List<MusicalGenre> musicalGenres = new ArrayList<MusicalGenre>();
    private List<MovieGenre> movieGenres = new ArrayList<MovieGenre>();
    private List<FoodType> foodTypes = new ArrayList<FoodType>();
    private int maxAmount = 0;


    public void addMusicalGenre(MusicalGenre genre){
        musicalGenres.add(genre);
    }

    public void removeMusicalGenre(MusicalGenre genre){ musicalGenres.remove(genre); }

    public boolean likeMusicalGenre(MusicalGenre genre){ return musicalGenres.contains(genre); }

    public void addMovieGenre(MovieGenre genre){ movieGenres.add(genre); }

    public void removeMovieGenre(MovieGenre genre){ movieGenres.remove(genre); }

    public boolean likeMovieGenre(MovieGenre genre){ return movieGenres.contains(genre); }

    public void addFoodType(FoodType foodType){
        foodTypes.add(foodType);
    }

    public void removeFoodType(FoodType foodType) { foodTypes.remove(foodType); }

    public boolean likeFoodType(FoodType foodType) { return foodTypes.contains(foodType); }

    public void setAmount(int amount){
        maxAmount = amount;
    }
}
