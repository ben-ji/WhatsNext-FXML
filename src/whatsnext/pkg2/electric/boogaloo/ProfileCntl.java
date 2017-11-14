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
 * @author daw5510
 */
public class ProfileCntl {
    
    private static Parent root;
    
    private static ProfileCntl instance;
    
    private static Stage stage;
    private ProfileModel pm;
    
    private ProfileCntl(Stage stage){
        this.stage = stage;
        this.pm = ProfileModel.getInstance();
    }
    
    public static ProfileCntl getInstance(Stage stage){
        if(instance == null){
            instance = new ProfileCntl(stage);
        }
            return instance;
        
    }
    
    public static void showEditUI(Parent root){
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    public static void showNavUI(Parent root){
        stage.setScene(new Scene(root));
        stage.show();
    }
    
}
