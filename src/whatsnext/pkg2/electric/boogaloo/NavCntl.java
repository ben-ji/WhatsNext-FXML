/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsnext.pkg2.electric.boogaloo;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Dylan
 */
public class NavCntl {
    
    Stage stage;
    private Parent root;
    private Scene scene;
    
    public NavCntl(Stage stage){
        this.stage = stage;
        try{
            root = FXMLLoader.load(getClass().getResource("NavUI.fxml"));
        } catch(IOException ex){
            System.out.println("Error fetching NavUI.fxml");
        }
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
