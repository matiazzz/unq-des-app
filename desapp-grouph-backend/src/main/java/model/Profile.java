package model;

import java.util.Set;
import java.util.HashSet;

public class Profile {
    private Set<MusicalGenre> musicalGenres = new HashSet<MusicalGenre>();
    private Set<MovieGenre> movieGenres = new HashSet<MovieGenre>();
    private Set<FoodType> foodTypes = new HashSet<FoodType>();
    private int maxAmount = 0;


    public void addMusicalGenre(MusicalGenre genre){ musicalGenres.add(genre); }

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

    public int getMaxAmount() { return maxAmount; }
}
