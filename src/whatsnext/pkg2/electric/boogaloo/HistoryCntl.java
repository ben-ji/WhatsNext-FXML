/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsnext.pkg2.electric.boogaloo;

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
    private static ObservableList<Media> listOfMediaHistory;
    
    
    private HistoryCntl(Stage stage) {
        this.stage = stage;
        
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
}
