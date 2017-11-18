/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsnext.pkg2.electric.boogaloo;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author cxg5334
 */
public class HistoryCntl {
    private static Parent root;
    private static Stage stage;
    private static HistoryCntl instance;
    private static ArrayList<Media> mediaList;

    
    
    private HistoryCntl(Stage stage) {
        this.stage = stage;
        mediaList = new ArrayList<Media>();
    }
        
    
    public static HistoryCntl getInstance(Stage stage){
        if(instance == null){
            instance = new HistoryCntl(stage);
        }
            return instance;        
    }
    
    public static void showProfileUI(Parent root, Stage stage){
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
    public static void addToMediaList(ArrayList<Media> aMediaList) {
        for(Media m : aMediaList){
            mediaList.add(m);
        }
    }
    public static void clearMediaList(){
        mediaList.clear();
    }

}
