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
public class FriendCntl {
    private static FriendCntl instance;
    
    private FriendCntl(){
        
    }
    
    public static FriendCntl getInstance(){
        if(instance == null){
            instance = new FriendCntl();
        }
        return instance;
    }

    void showFriendRecommendationUI(Stage stage) {
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource("FriendRecommendationUI.fxml"));
        } catch(IOException ex){
            System.out.println("Error fetching FriendRecommendationUI.fxml");
        }
        stage.setScene(new Scene(root));
        stage.show();
    }
}


