package model;

import model.events.Event;
import model.events.EventData;
import model.plannings.Couple;
import model.plannings.Individual;
import model.plannings.Planning;
import model.plannings.WithFriends;
import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String lastname;
    private LocalDate birthday;
    private String username;
    //private String password;
    private List<User> friends = new ArrayList<User>();
    private Profile profile;
    private List<Event> events = new ArrayList<Event>();
    private List<Planning> plannings = new ArrayList<Planning>();
    private List<Invitation> invitations = new ArrayList<Invitation>();

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
        Individual plan = new Individual(this, LocalDate.now());
        this.plannings.add(plan);
        return plan;
    }

    public Couple createCouplePlan(){
        Couple plan = new Couple(this, LocalDate.now());
        this.plannings.add(plan);
        return plan;
    }

    public WithFriends createWithFriendsPlan(){
        WithFriends plan = new WithFriends(this, LocalDate.now());
        this.plannings.add(plan);
        return plan;
    }

    public Invitation inviteFriendTo(Planning plan, User friend){
        Invitation invitation = new Invitation(this, plan);
        friend.invitations.add(invitation);
        return invitation;
    }

    public void addPlanning(Planning planning){
        this.plannings.add(planning);
    }

    public boolean hasPlanning(Planning plan){
        return plannings.contains(plan);
    }

    public boolean hasInvitation(Invitation invitation){
        return invitations.contains(invitation);
    }

    public void acceptInvitationTo(Invitation invitation){
        invitation.accept(this);
    }

    public void addMusicGenre(MusicalGenre genre){
        profile.addMusicalGenre(genre);
    }

    public void removeMusicalGenre(MusicalGenre genre){
        profile.removeMusicalGenre(genre);
    }

    public boolean likeMusicalGenre(MusicalGenre genre) {
        return profile.likeMusicalGenre(genre);
    }

    public void addMovieGenre(MovieGenre genre){
        profile.addMovieGenre(genre);
    }

    public  void removeMovieGenre(MovieGenre genre){
        profile.removeMovieGenre(genre);
    }

    public boolean likeMovieGenre(MovieGenre genre) {
        return profile.likeMovieGenre(genre); }

    public void addFoodType(FoodType foodType){
        profile.addFoodType(foodType);
    }

    public void removeFoodType(FoodType foodType){
        profile.removeFoodType(foodType);
    }

    public boolean likeFoodType(FoodType type) {
        return profile.likeFoodType(type);
    }

    public void setAmount(int amount){
        profile.setAmount(amount);
    }

    public int getMaxAmount(){
        return profile.getMaxAmount();
    }

    public boolean isFriendOf(User friend) {
        return this.friends.contains(friend);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public void setPlannings(List<Planning> plannings) {
        this.plannings = plannings;
    }

    public void setInvitations(List<Invitation> invitations) {
        this.invitations = invitations;
    }

    public Profile getProfile() {
        return profile;
    }

    public List<User> getFriends() {
        return friends;
    }
}
