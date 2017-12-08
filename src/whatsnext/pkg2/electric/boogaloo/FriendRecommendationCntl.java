/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsnext.pkg2.electric.boogaloo;

import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Dylan
 */
public class FriendRecommendationCntl {
    private static FriendRecommendationCntl instance;

    private String friendName;
    private String friendGenre1;
    private String friendGenre2;
    private ArrayList<Media> recommendationsList;
    
    private FriendRecommendationCntl(){
        friendName = "error";
        friendGenre1 = "error";
        friendGenre2 = "error";
    }

    public static FriendRecommendationCntl getInstance(){
        if(instance == null){
            instance = new FriendRecommendationCntl();
        }
        return instance;
    }
    
    public void printContents(){
        System.out.println(this.friendName + ": " + friendGenre1 + ", " + friendGenre2);
        System.out.println("List of Media:");
        for(Media m: recommendationsList){
            System.out.println(m.getTitle() + ", " + m.getGenre1() + " and " + m.getGenre2());
        }
    }    
    /**
     * @return the friendName
     */
    public String getFriendName() {
        return friendName;
    }

    /**
     * @param friendName the friendName to set
     */
    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    /**
     * @return the friendGenre1
     */
    public String getFriendGenre1() {
        return friendGenre1;
    }

    /**
     * @param friendGenre1 the friendGenre1 to set
     */
    public void setFriendGenre1(String friendGenre1) {
        this.friendGenre1 = friendGenre1;
    }

    /**
     * @return the friendGenre2
     */
    public String getFriendGenre2() {
        return friendGenre2;
    }

    /**
     * @param friendGenre2 the friendGenre2 to set
     */
    public void setFriendGenre2(String friendGenre2) {
        this.friendGenre2 = friendGenre2;
    }

    /**
     * @return the recommendationsList
     */
    public ArrayList<Media> getRecommendationsList() {
        return recommendationsList;
    }

    /**
     * @param recommendationsList the recommendationsList to set
     */
    public void setRecommendationsList(ArrayList<Media> recommendationsList) {
        this.recommendationsList = recommendationsList;
    }

    void showFriendUI(Parent root, Stage stage) {
        try{
            root = FXMLLoader.load(getClass().getResource("FriendUI.fxml"));
        } catch(IOException ex){
            System.out.println("Error fetching FriendUI.fxml");
        }
        stage.setScene(new Scene(root));
        stage.show();
    }

    void showFriendRecommendationUI(Parent root, Stage stage) {
        try{
            root = FXMLLoader.load(getClass().getResource("FriendRecommendationUI.fxml"));
        } catch(IOException ex){
            System.out.println("Error fetching FriendRecommendationUI.fxml");
        }
        stage.setScene(new Scene(root));
        stage.show();
    }
    
}
