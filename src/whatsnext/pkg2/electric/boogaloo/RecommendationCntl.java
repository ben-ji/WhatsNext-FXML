/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsnext.pkg2.electric.boogaloo;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Benjamin
 */
public class RecommendationCntl {
    private static RecommendationCntl instance;
    private static Stage stage;
    private static Parent root;
    
    private RecommendationCntl(Stage stage){
        this.stage = stage;
    }
    
    public static RecommendationCntl getInstance(Stage stage){
        if(instance == null){
            instance = new RecommendationCntl(stage);
        }
        return instance;
    }
    public static void showNavUI(Parent root, Stage stage){
            stage.setScene(new Scene(root));
            stage.show();
        }    
}
