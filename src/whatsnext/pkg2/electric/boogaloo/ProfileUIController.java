/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsnext.pkg2.electric.boogaloo;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
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
    private Button historyButton;
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
    @FXML
    private Stage stage;
    @FXML
    private Parent root;
    @FXML
    private Scene scene;
    @FXML
    private Label favGenresDisplay;
    @FXML
    private Label userInfoDisplay;
    @FXML
    private Label achievementsDisplay;
    @FXML
    private Label friendsDisplay;
    @FXML
    private ImageView profilePicView;
    @FXML
    private Button profilePicButton;
    @FXML
    private String imageFile;
   
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
        this.loadPreviousProPic();
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
    
    @FXML
    private void showHistoryUI(ActionEvent event) {
        stage = (Stage)historyButton.getScene().getWindow();
        try{
            root = FXMLLoader.load(getClass().getResource("HistoryUI.fxml"));
        } catch(IOException ex){
            ex.printStackTrace();
        }
        ProfileCntl.getInstance(stage).showHistoryUI(root);
    }
    
    private void loadPreviousProPic(){
        if(!(ProfileModel.getInstance().getImage() == null)){
            profilePicView.setImage(ProfileModel.getInstance().getImage());
        }
    }
    
    
    @FXML
    private void loadImage(ActionEvent event) throws MalformedURLException {
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image File");
        File selectedFile = fileChooser.showOpenDialog(exitButton.getScene().getWindow());
        if (selectedFile != null) {
            imageFile = selectedFile.toURI().toURL().toString();
            
            Image image = new Image(imageFile);
            profilePicView.setImage(image);
            ProfileModel.getInstance().setImage(image);
        }
    }
}
