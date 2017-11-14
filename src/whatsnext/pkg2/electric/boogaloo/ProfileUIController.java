/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsnext.pkg2.electric.boogaloo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dylan
 */
public class ProfileUIController implements Initializable {

    @FXML
    private Button exitButton;
    @FXML
    private Button logoutButton;
    @FXML
    private Button optionsButton;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label dateCreated;
    @FXML
    private Label userInfoLabel;
    @FXML
    private Label favGenreLabel;
    @FXML
    private Label achievementsLabel;
    @FXML
    private Label friendsLabel;
    private Stage stage;
    private Parent root;
    private Scene scene;
    @FXML
    private Label favGenresDisplay;
    @FXML
    private Label userInfoDisplay;
    @FXML
    private Label achievementsDisplay;
    @FXML
    private Label friendsDisplay;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String username = "username";
        String dateCreate = "dateCreated";
        ProfileModel pm = ProfileModel.getInstance();
        usernameLabel.setText(pm.getUsername());
        dateCreated.setText(pm.getDateCreated());
        userInfoDisplay.setText(pm.getUserInfo());
        favGenresDisplay.setText(pm.getGenres());
        achievementsDisplay.setText(pm.getAchievements());
        friendsDisplay.setText(pm.getFriends());
    }    

    @FXML
    private void showNavUI(ActionEvent event) {
        stage = (Stage)usernameLabel.getScene().getWindow();
        try{
            root = FXMLLoader.load(getClass().getResource("NavUI.fxml"));
        } catch(IOException ex){
            ex.printStackTrace();
        }
        ProfileCntl.getInstance(stage).showNavUI(root);
    }

    @FXML
    private void exitProgram(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void showOptionsUI(ActionEvent event) {
        //TODO: add options
    }

    @FXML
    private void showEditProfileUI(ActionEvent event) {
        stage = (Stage)usernameLabel.getScene().getWindow();
        try{
            root = FXMLLoader.load(getClass().getResource("EditUI.fxml"));
        } catch(IOException ex){
            ex.printStackTrace();
        }
        ProfileCntl.getInstance(stage).showEditUI(root);
    }
    
}
