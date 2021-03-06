package model.builders;

import model.users.FoodType;
import model.users.MovieGenre;
import model.users.MusicalGenre;
import model.users.Profile;
import java.util.HashSet;
import java.util.Set;

public class ProfileBuilder {

    private Set<MusicalGenre> musicalGenres;
    private Set<MovieGenre> movieGenres;
    private Set<FoodType> foodTypes;
    private int maxAmount = 0;

    public ProfileBuilder(){
        this.musicalGenres = new HashSet<>();
        this.movieGenres = new HashSet<>();
        this.foodTypes = new HashSet<>();
        this.maxAmount = 0;
    }

    public static ProfileBuilder anyProfile(){
        return new ProfileBuilder();
    }

    public Profile build(){
       return new Profile(this.musicalGenres, this.movieGenres, this.foodTypes, this.maxAmount);
    }

    public ProfileBuilder with(MusicalGenre genre){
        this.musicalGenres.add(genre);
        return this;
    }

    public ProfileBuilder with(MovieGenre genre){
        this.movieGenres.add(genre);
        return this;
    }

    public ProfileBuilder with(FoodType type){
        this.foodTypes.add(type);
        return this;
    }
}

