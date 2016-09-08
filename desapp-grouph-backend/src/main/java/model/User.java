package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {

    private String name;
    private String lastname;
    private LocalDate birthday;
    private String username;
    private String password;
    private List<User> friends = new ArrayList<User>();
    private Profile profile;
    private List<Event> events = new ArrayList<Event>();
    private List<Planning> plannings = new ArrayList<Planning>();


    public User(String name, String lastname, LocalDate birthday, String username, String password,Profile profile, List<User> friends, List<Event> events, List<Planning> plannings){
        this.name = name;
        this.lastname = lastname;
        this.birthday = birthday;
        this.username = username;
        this.password = password;
        this.profile = profile;
        this.friends = friends;
        this.events = events;
        this.plannings = plannings;
    }

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

    public void connectFriend(User friend){
        friend.addFriend(this);
        this.addFriend(friend);
    }

    public Event createEvent(EventData eventData){
        Event event = new Event(eventData);
        events.add(event);
        return event;
    }

    public Individual createIndividualPlan(){
        //TODO
        return null;
    }

    public Couple createCouplePlan(){
        //TODO
        return null;
    }

    public WithFriends createWithFriendsPlan(){
        //TODO
        return null;
    }

    public void inviteFriendTo(Planning plan, User friend){
        //TODO
    }

    public void aceptInvitationTo(Planning plan){
        //TODO
    }

    public void addMusicGenre(MusicalGenre genre){
        profile.addMusicalGenre(genre);
    }

    public void removeMusicalGenre(MusicalGenre genre){
        profile.removeMusicalGenre(genre);
    }

    public boolean likeMusicalGenre(MusicalGenre genre) { return profile.likeMusicalGenre(genre); }

    public void addMovieGenre(MovieGenre genre){
        profile.addMovieGenre(genre);
    }

    public  void removeMovieGenre(MovieGenre genre){
        profile.removeMovieGenre(genre);
    }

    public boolean likeMovieGenre(MovieGenre genre) { return profile.likeMovieGenre(genre); }

    public void addFoodType(FoodType foodType){
        profile.addFoodType(foodType);
    }

    public void removeFoodType(FoodType foodType){
        profile.removeFoodType(foodType);
    }

    public boolean likeFoodType(FoodType type) { return profile.likeFoodType(type); }

    public void setAmount(int amount){
        profile.setAmount(amount);
    }

    public int getMaxAmount(){ return profile.getMaxAmount(); }

    public boolean isFriendWith(User friend){ return this.friends.contains(friend); }



    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getBirthday() {
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

    public Profile getProfile() { return profile; }

}
