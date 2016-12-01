package model.users;

import model.events.Event;
import model.events.EventData;
import model.events.Events;
import model.plannings.Couple;
import model.plannings.Individual;
import model.plannings.Planning;
import model.plannings.WithFriends;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;
import org.joda.time.LocalDate;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="User")
public class User extends model.Entity {

    private static final long serialVersionUID = 6716714837006810519L;

    private String name;
    private String lastName;
    private LocalDate birthday;
    private String userName;
    @Column(length = 10000)
    private Profile profile;
    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    private List<User> friends = new ArrayList<>();
    @Column(length = 10000)
    private Events myEvents = new Events();
    @Transient
    private Events going = new Events();
    @Transient
    private List<Planning> plannings = new ArrayList<>();
    @OneToMany(fetch = FetchType.EAGER)
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    private List<Invitation> invitations = new ArrayList<>();

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
        myEvents.add(event);
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

    public void acceptInvitationTo(Invitation invitation){ invitation.accept(this); }

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

    public boolean likeMovieGenre(MovieGenre genre) { return profile.likeMovieGenre(genre); }

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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void setPlannings(List<Planning> plannings) {
        this.plannings = plannings;
    }

    public void setInvitations(List<Invitation> invitations) {
        this.invitations = invitations;
    }

    public List<Invitation> getInvitations() {
        return invitations;
    }

    public Profile getProfile() {
        return profile;
    }

    public List<User> getFriends() {
        return friends;
    }

    public List<Planning> getPlannings() {
        return plannings;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getUserName() {
        return userName;
    }

    public Events getEvents() {
        return myEvents;
    }

    public boolean possiblyLikes(Event event) {
        return event.getType().possiblyLikes(getProfile());
    }

    public void addEvent(Event event){
        this.myEvents.add(event);
    }

    public void addGoingEvent(Event event) {
        this.going.add(event);
    }

    public Events getMyEvents() {
        return myEvents;
    }

    public void setMyEvents(Events myEvents) {
        this.myEvents = myEvents;
    }

    public Events getGoing() {
        return going;
    }

    public void setGoing(Events going) {
        this.going = going;
    }
}
