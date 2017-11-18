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
    private static ProfileModel instance = null;
    private String username;
    private String dateCreated;
    private String userInfo;
    private String genres;
    private String achievements;
    private String friends;
    
    private ProfileModel(){
        this.username = "username";
        this.dateCreated = "dateCreated";
        this.userInfo = "Hit \"Edit User Info\" button to edit your user info!";
        this.genres = "";
        this.achievements = "";
        this.friends = "";
    }
    
    private ProfileModel(String username, String dateCreated){
        this.username = username;
        this.dateCreated = dateCreated;
        userInfo = "Hit \"Edit...\" to edit your user info!";
        this.genres = "";
        this.achievements = "";
        this.friends = "";
    }
    
    public static ProfileModel getInstance(){
        if(instance == null){
            instance = new ProfileModel();
        }
        return instance;
    }
    
    public static ProfileModel getInstance(String username, String dateCreated){
        if(instance == null){
            instance = new ProfileModel(username, dateCreated);
        }
        return instance;
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
    public String getGenres() {
        return genres;
    }

    /**
     * @param genres the genres to set
     */
    public void setGenres(String genres) {
        this.genres = genres;
    }

    /**
     * @return the achievements
     */
    public String getAchievements() {
        return achievements;
    }

    /**
     * @param achievements the achievements to set
     */
    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    /**
     * @return the friends
     */
    public String getFriends() {
        return friends;
    }

    /**
     * @param friends the friends to set
     */
    public void setFriends(String friends) {
        this.friends = friends;
    }
    
}
