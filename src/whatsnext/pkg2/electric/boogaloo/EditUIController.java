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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dylan
 */
public class EditUIController implements Initializable {

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
    @FXML
    private Button doneButton;
    private Stage stage;
    private Parent root;
    private Scene scene;
    @FXML
    private TextField userInfoField;
    @FXML
    private TextField favGenreField;
    @FXML
    private TextField achievementsField;
    @FXML
    private TextField friendsField;
    private ProfileModel pm;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String username = "username";
        String dateCreate = "dateCreated";
        pm = ProfileModel.getInstance();
        usernameLabel.setText(pm.getUsername());
        dateCreated.setText(pm.getDateCreated());
    }    

    @FXML
    private void showNavUI(ActionEvent event) {
        stage = (Stage)usernameLabel.getScene().getWindow();
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
    private void exitProgram(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void showOptionsUI(ActionEvent event) {
        //TODO: add options
    }

    @FXML
    private void updateModel(ActionEvent event) {
        System.out.println("Setting userInfo");
        pm.setUserInfo(userInfoField.getText());
        System.out.println("Setting genres");
        pm.setGenres(favGenreField.getText());
        System.out.println("Setting achievements");
        pm.setAchievements(achievementsField.getText());
        System.out.println("Setting Friends");
        pm.setFriends(friendsField.getText());
        stage = (Stage)usernameLabel.getScene().getWindow();
        try{
            root = FXMLLoader.load(getClass().getResource("ProfileUI.fxml"));
        } catch(IOException ex){
            ex.printStackTrace();
        }
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
