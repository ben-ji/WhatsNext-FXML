/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsnext.pkg2.electric.boogaloo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
 * @author Dylan
 */
public class NavUIController implements Initializable {

    private Button profileButton;
    private Scene scene;
    private Stage stage;
    private Parent root;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void showProfile(){
        stage = (Stage)profileButton.getScene().getWindow();
        try{
            root = FXMLLoader.load(getClass().getResource("ProfileUI.fxml"));
        } catch(IOException ex){
            System.out.println("Error fetching Profile.fxml");
        }
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
