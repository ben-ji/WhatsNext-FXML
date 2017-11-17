/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsnext.pkg2.electric.boogaloo;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author cxg5334
 */
public class HistoryUIController {
    @FXML
    private Button returnButton;
    @FXML
    private Button remove;
    @FXML
    private Button clear;
    private Stage stage;
    private Parent root;
    private Scene scene;
    
    @FXML
    private void showProfileUI(ActionEvent event){
        stage= (Stage)returnButton.getScene().getWindow();
        try {
            root = FXMLLoader.load(getClass().getResource("ProfileUI.fxml"));
        } catch(IOException ex){
            ex.printStackTrace();
        }
        HistoryCntl.getInstance(stage).showProfileUI(root, stage);
    }
    
}
