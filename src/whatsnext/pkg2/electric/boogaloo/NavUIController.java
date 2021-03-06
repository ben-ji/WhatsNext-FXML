/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsnext.pkg2.electric.boogaloo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dylan
 */
public class NavUIController implements Initializable {

    @FXML
    private Button profileButton;
    private Scene scene;
    private Stage stage;
    private Parent root;
    @FXML
    private Button logoutButton;
    @FXML
    private Button menuSearchButton;
    @FXML
    private Button recommendationButton;
    @FXML
    private Button historyButton;
    @FXML
    private Button friendsListButton;
    @FXML
    private Button helpButton;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    public void showProfile(){
        stage = (Stage)profileButton.getScene().getWindow();
        NavCntl.getInstance(stage).showProfile(stage);
    }
    
    @FXML
    private void exitProgram(ActionEvent event) {
        System.exit(0);
    }
    
    @FXML
    public void showSearch(){
        stage = (Stage)menuSearchButton.getScene().getWindow();
        NavCntl.getInstance(stage).showSearch(stage);
    }
    @FXML
    public void showRecommendation(){
        stage = (Stage)recommendationButton.getScene().getWindow();
        NavCntl.getInstance(stage).showRecommendation(stage);
    }
    
    @FXML
    public void showHistory(){
        stage = (Stage)historyButton.getScene().getWindow();
        NavCntl.getInstance(stage).showHistory(stage);
    }
    
    @FXML
    public void showFriendUI(){
        stage = (Stage)friendsListButton.getScene().getWindow();
        NavCntl.getInstance(stage).showFriendUI(stage);
    }
    
    @FXML
    public void showHelp(){
        stage = (Stage)helpButton.getScene().getWindow();
        NavCntl.getInstance(stage).showHelp(stage);
    }
}
