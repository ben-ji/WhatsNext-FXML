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
    
    public static NavCntl getInstance(Stage stage){
        if(instance == null){
            instance = new NavCntl(stage);
            return instance;
        }
        else{
            return instance;
        }
    }
    
    public void showProfile(Stage stage){
        
        try{
            root = FXMLLoader.load(getClass().getResource("ProfileUI.fxml"));
        } catch(IOException ex){
            System.out.println("Error fetching ProfileUI.fxml");
        }
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void showSearch(Stage stage){
        
        try{
            root = FXMLLoader.load(getClass().getResource("SearchUI.fxml"));
        } catch(IOException ex){
            System.out.println("Error fetching SearchUI.fxml");
        }
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void showRecommendation(Stage stage){
        
        try{
            root = FXMLLoader.load(getClass().getResource("RecommendationUI.fxml"));
        } catch(IOException ex){
            System.out.println("Error fetching RecommendationUI.fxml");
        }
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
