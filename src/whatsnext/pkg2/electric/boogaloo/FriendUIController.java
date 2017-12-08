/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsnext.pkg2.electric.boogaloo;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Benjamin
 */
public class FriendUIController implements Initializable {

    @FXML
    private Button returnButton;
    private Stage stage;
    private Parent root;
    private Scene scene;
    private ArrayList<Media> mediaList;
    @FXML
    private Button kevinButton;
    @FXML
    private Button charleneButton;
    @FXML
    private Button borisButton;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mediaList = new ArrayList<Media>();
    }   
    
    @FXML
    private void showNavUI(ActionEvent event) {
        stage = (Stage)returnButton.getScene().getWindow();
        try{
            root = FXMLLoader.load(getClass().getResource("NavUI.fxml"));
        } catch(IOException ex){
            System.out.println("Error fetching NavUI.fxml");
        }
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void kSearch(ActionEvent event) {
        FriendRecommendationCntl.getInstance().setFriendName("Kevin");
        FriendRecommendationCntl.getInstance().setFriendGenre1("Thriller");
        FriendRecommendationCntl.getInstance().setFriendGenre2("Horror");
        ArrayList<Media> passthroughList = new ArrayList<Media>();
        ArrayList<String> genres = new ArrayList<String>();
        genres.add("Horror");
        genres.add("Cartoon");
        genres.add("Romance");
        genres.add("Comedy");
        genres.add("Thriller");
        genres.add("Documentary");
        String tempTitle;
        String tempGenre1;
        String tempGenre2; 
        for(int i = 0; i < 20; i ++){
            tempGenre1 = genres.get(ThreadLocalRandom.current().nextInt(0, 6));
            tempGenre2 = genres.get(ThreadLocalRandom.current().nextInt(0, 6));
            tempTitle = "Book" + (i+1);
            mediaList.add(new Book(tempTitle,tempGenre1, tempGenre2,"description",99, "author", 10));
        }
        for(int i = 0; i < 20; i ++){
            tempGenre1 = genres.get((i+2) % 6);
            tempGenre2 = genres.get(((i+2)*i)%6);
            tempTitle = "Movie" + (i+1);
            mediaList.add(new Movie(tempTitle,tempGenre1, tempGenre2,"description",99, "rating", 10));
        }
        for(Media m : mediaList){
            if(m.getGenre1().equalsIgnoreCase("Thriller") || m.getGenre2().equalsIgnoreCase("Thriller")){
                passthroughList.add(m);
            } 
            else{
                if(m.getGenre1().equalsIgnoreCase("Horror") || m.getGenre2().equalsIgnoreCase("Horror")){
                    passthroughList.add(m);
                }  
            }
        }
        FriendRecommendationCntl.getInstance().setRecommendationsList(passthroughList);
        this.showFriendRecommendationUI();

    }

    @FXML
    private void cSearch(ActionEvent event) {
    }

    @FXML
    private void bSearch(ActionEvent event) {
    }

    private void showFriendRecommendationUI() {
        stage = (Stage)returnButton.getScene().getWindow();
        FriendCntl.getInstance().showFriendRecommendationUI(stage);
    }
}
