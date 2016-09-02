package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    private String name;
    private String lastname;
    private Date birthday;
    private String username;
    private String password;
    private List<User> friends = new ArrayList<User>();
    private Profile profile;
    private List<Event> events = new ArrayList<Event>();
    private List<Planning> plannings = new ArrayList<Planning>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        profile = new Profile();
    }

    public User(){
        profile = new Profile();
    }

    public void addFriend(User friend){
        friends.add(friend );
    }

    public void acceptFriend(User friend){
        friend.addFriend(this);
        this.addFriend(friend);
    }

    public Event createEvent(EventData eventData){
        Event event = new Event(eventData);
        events.add(event);
        return event;
    }

    public void addMusicGenre(MusicalGenre genre){
        profile.addMusicalGenre(genre);
    }

    public void removeMusicalGenre(MusicalGenre genre){
        profile.removeMusicalGenre(genre);
    }

    public void addMovieGenre(MovieGenre genre){
        profile.addMovieGenre(genre);
    }

    public  void removeMovieGenre(MovieGenre genre){
        profile.removeMovieGenre(genre);
    }

    public void addFoodType(FoodType foodType){
        profile.addFoodType(foodType);
    }

    public void removeFoodType(FoodType foodType){
        profile.removeFoodType(foodType);
    }

    public void setAmount(int amount){
        profile.setAmount(amount);
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getUsername() {
        return username;
    }

    private String getPassword() {
        return password;
    }

    public List<User> getFriends() {
        return friends;
    }
}
