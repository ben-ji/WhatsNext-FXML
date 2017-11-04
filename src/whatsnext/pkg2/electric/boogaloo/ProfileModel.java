/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsnext.pkg2.electric.boogaloo;

import java.util.ArrayList;

/**
 *
 * @author Dylan
 */
public class ProfileModel {
    
    private String username;
    private String dateCreated;
    private String userInfo;
    private ArrayList<String> genres;
    private ArrayList<String> achievements;
    private ArrayList<String> friends;
    
    public ProfileModel(String username, String dateCreated){
        this.username = username;
        this.dateCreated = dateCreated;
        userInfo = "Hit \"Edit...\" to edit your user info!";
        genres = new ArrayList();
        achievements = new ArrayList();
        friends = new ArrayList();
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the dateCreated
     */
    public String getDateCreated() {
        return dateCreated;
    }

    /**
     * @param dateCreated the dateCreated to set
     */
    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * @return the userInfo
     */
    public String getUserInfo() {
        return userInfo;
    }

    /**
     * @param userInfo the userInfo to set
     */
    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    /**
     * @return the genres
     */
    public ArrayList<String> getGenres() {
        return genres;
    }

    /**
     * @param genres the genres to set
     */
    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    /**
     * @return the achievements
     */
    public ArrayList<String> getAchievements() {
        return achievements;
    }

    /**
     * @param achievements the achievements to set
     */
    public void setAchievements(ArrayList<String> achievements) {
        this.achievements = achievements;
    }

    /**
     * @return the friends
     */
    public ArrayList<String> getFriends() {
        return friends;
    }

    /**
     * @param friends the friends to set
     */
    public void setFriends(ArrayList<String> friends) {
        this.friends = friends;
    }
    
}
