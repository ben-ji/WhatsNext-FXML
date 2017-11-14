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
    
    private static NavCntl instance = null;
    private Parent root;
    private Scene scene;
    private Stage stage;
    
    private NavCntl(Stage stage){
        this.stage = stage;
    }
    
    public NavCntl getInstance(Stage stage){
        if(this.instance == null){
            this.instance = new NavCntl(stage);
            return instance;
        }
        else{
            return instance;
        }
    }
    
}
