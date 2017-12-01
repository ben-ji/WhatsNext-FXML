/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsnext.pkg2.electric.boogaloo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Benjamin
 */
public class RecommendationCntl {

    private static RecommendationCntl instance;
    private static ArrayList<Media> historyList;
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
    
    public static void readHistoryFile(ArrayList<Media> historyList) {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try{
            fis = new FileInputStream("mediaList.ser");
            in = new ObjectInputStream(fis);
            historyList = (ArrayList<Media>)in.readObject();
            in.close();
            if(!historyList.isEmpty()){
                System.out.println("historyList has content!");
            }           
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @return the historyList
     */
    public static ArrayList<Media> getHistoryList() {
        return historyList;
    }
    
    
    /**
     * @return the root
     */
    public static Parent getRoot() {
        return root;
    }

    /**
     * @param aRoot the root to set
     */
    public static void setRoot(Parent aRoot) {
        root = aRoot;
    }
}
