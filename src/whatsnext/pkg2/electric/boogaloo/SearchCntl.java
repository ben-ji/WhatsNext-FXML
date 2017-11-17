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
 * @author Benjamin
 */
public class SearchCntl {
    
    private static Parent root;
    private static SearchCntl instance;
    private static Stage stage;
    private SearchModel sm;
    
    public SearchCntl(Stage stage) {
        this.stage = stage;
        this.sm = SearchModel.getInstance();
    }
    
   
    public static SearchCntl getInstance(Stage stage1){
        if(instance == null){
            instance = new SearchCntl(stage1);
        }
            return instance;
        
    }
    
    public static void showNavUI(Parent root){
        stage.setScene(new Scene(root));
        stage.show();
    }

}
