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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Benjamin
 */
public class FriendRecommendationUIController implements Initializable {
    @FXML
    private Button returnButton;
    private Stage stage;
    private Parent root;
    private Scene scene;
    
    @FXML
    private Button selectResultButton;
    @FXML
    private TableView<?> resultsTable;
    @FXML
    private TableColumn<?, ?> titleColumn;
    @FXML
    private TableColumn<?, ?> genreColumn;
    @FXML
    private TableColumn<?, ?> subGenreColumn;
    @FXML
    private TableColumn<?, ?> descriptionColumn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        // TODO
    }    
    
    @FXML
    private void showFriendUI(ActionEvent event) {
        stage = (Stage)returnButton.getScene().getWindow();
        try{
            root = FXMLLoader.load(getClass().getResource("FriendUI.fxml"));
        } catch(IOException ex){
            ex.printStackTrace();
        }
        FriendRecommendationCntl.getInstance().showFriendUI(root, stage);
        
    }

    @FXML
    private void getSelectedRow(ActionEvent event) {
    }
}
