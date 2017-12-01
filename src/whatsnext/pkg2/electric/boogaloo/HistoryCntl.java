/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsnext.pkg2.electric.boogaloo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
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
    private static String mediaListFileName = "mediaList.ser";

    
    
    private HistoryCntl(Stage stage) {
        this.stage = stage;
        this.readMediaListFile();
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
        HistoryCntl.writeMediaListFile();
    }
    
    public static void removeByIndex(int index){
        mediaList.remove(index);
    }
    
    public static void clearMediaList(){
        mediaList.clear();
    }
    
    public static void updateMediaListFile(){
        HistoryCntl.writeMediaListFile();
    }

    private void readMediaListFile() {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try{
            fis = new FileInputStream(mediaListFileName);
            in = new ObjectInputStream(fis);
            mediaList = (ArrayList<Media>)in.readObject();
            in.close();
            if(!mediaList.isEmpty()){
                System.out.println("MediaList has content!");
            }           
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private static void writeMediaListFile() {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        System.out.println(mediaList);
        try {
            fos = new FileOutputStream(mediaListFileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(mediaList);
            out.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

}
