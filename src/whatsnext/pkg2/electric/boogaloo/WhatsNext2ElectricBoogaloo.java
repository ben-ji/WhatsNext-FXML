/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsnext.pkg2.electric.boogaloo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import javafx.stage.Stage;

/**
 *
 * @author daw5510
 */
public class WhatsNext2ElectricBoogaloo extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LoginUI.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("What's Next?");
        stage.getIcons().add(new Image("http://2.bp.blogspot.com/_50XFw6_2Jxw/TH0b0U6Fn6I/AAAAAAAAADQ/yK052vx3mAw/s1600/Screen+shot+2010-08-31+at+11.11.46+AM.png"));
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
