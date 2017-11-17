/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsnext.pkg2.electric.boogaloo;

import java.util.ArrayList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Dylan
 */
public class ResultController {
    private static ArrayList<Media> mediaList;
    
    private static Parent root;
    private static Stage stage;
    private static ResultController instance;
    
    
    public ResultController(Stage stage) {
        this.stage = stage;
        
    }
        
    
    public static ResultController getInstance(Stage stage){
        if(instance == null){
            instance = new ResultController(stage);
        }
            return instance;        
    }
    
    public static void showSearchUI(Parent root, Stage stage){
        stage.setScene(new Scene(root));
        stage.show();
    }
    /**
     * @return the mediaList
     */
    public static ArrayList<Media> getMediaList() {
        return mediaList;
    }

    /**
     * @param aMediaList the mediaList to set
     */
    public static void setMediaList(ArrayList<Media> aMediaList) {
        mediaList = aMediaList;
    }
    
}
