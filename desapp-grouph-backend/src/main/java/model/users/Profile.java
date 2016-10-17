package model.users;

import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name="Profile")
public class Profile extends model.Entity {

    private static final long serialVersionUID = 6718914837006810519L;

    private int maxAmount = 0;
    @ElementCollection(targetClass = MusicalGenre.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<MusicalGenre> musicalGenres = new HashSet<>();
    @ElementCollection(targetClass = MovieGenre.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<MovieGenre> movieGenres = new HashSet<>();
    @ElementCollection(targetClass = FoodType.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<FoodType> foodTypes = new HashSet<>();

    public Profile(Set<MusicalGenre> musicalGenres, Set<MovieGenre> movieGenres, Set<FoodType> foodTypes, int maxAmount){
        this.musicalGenres = musicalGenres;
        this.movieGenres = movieGenres;
        this.foodTypes = foodTypes;
        this.maxAmount = maxAmount;
    }

    public Profile(){}

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

    public boolean likeManyFoodTypes() {
        return foodTypes.size() >= 5;
    }

    public boolean likeManyMusicalGenres() {
        return musicalGenres.size() >= 5;
    }

    public boolean likeManyMovieGenres() {
        return movieGenres.size() >= 5;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public Set<MusicalGenre> getMusicalGenres() {
        return musicalGenres;
    }

    public Set<MovieGenre> getMovieGenres() {
        return movieGenres;
    }

    public Set<FoodType> getFoodTypes() {
        return foodTypes;
    }

}
