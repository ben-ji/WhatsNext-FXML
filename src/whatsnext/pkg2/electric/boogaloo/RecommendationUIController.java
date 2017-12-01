/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsnext.pkg2.electric.boogaloo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Benjamin
 */
public class RecommendationUIController implements Initializable {

    @FXML
    private TableView<?> resultsTable;
    @FXML
    private TableColumn<?, ?> titleColumn;
    @FXML
    private TableColumn<?, ?> genreColumn;
    @FXML
    private TableColumn<?, ?> subGenreColumn;
    @FXML
    private TableColumn<?, ?> descriptionColumn;
    @FXML
    private Button exitButton;
    @FXML
    private Button openSelectionButton;
    private Stage stage;
    private Parent root;
    private Scene scene;
    private ArrayList<Media> mediaList = new ArrayList<Media>();
    private ObservableList<Media> observableMediaList;
    private int horror = 0;
    private int cartoon = 0;
    private int romance = 0;
    private int comedy = 0;
    private int thriller = 0;
    private int documentary = 0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try{
            fis = new FileInputStream("mediaList.ser");
            in = new ObjectInputStream(fis);
            mediaList = (ArrayList<Media>)in.readObject();
            in.close();
            if(!mediaList.isEmpty()){
                System.out.println("historyList has content!");
            }           
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        for(Media m : mediaList){
            System.out.println(m.getTitle());
        }
        tallyGenres(mediaList);
    }    
    @FXML
    private void showNavUI(ActionEvent event) {
        stage = (Stage)exitButton.getScene().getWindow();
        try{
            root = FXMLLoader.load(getClass().getResource("NavUI.fxml"));
        } catch(IOException ex){
            ex.printStackTrace();
        }
        RecommendationCntl.getInstance(stage).showNavUI(root, stage);
        
    }

    private void tallyGenres(ArrayList<Media> mediaList) {
        for(Media m : mediaList){
            switch(m.getGenre1()){
                case "Horror":
                    horror+= 2;
                    break;
                case "Cartoon":
                    cartoon+= 2;
                    break;
                case "Romance":
                    romance+= 2;
                    break;
                case "Comedy":
                    comedy+= 2;
                    break;
                case "Thriller":
                    thriller+= 2;
                case "Documentary":
                    documentary+= 2;
            }
            switch(m.getGenre2()){
                case "Horror":
                    horror++;
                    break;
                case "Cartoon":
                    cartoon++;
                    break;
                case "Romance":
                    romance++;
                    break;
                case "Comedy":
                    comedy++;
                    break;
                case "Thriller":
                    thriller++;
                case "Documentary":
                    documentary++;
            }
        }
        System.out.println(horror);
        System.out.println(cartoon);
        System.out.println(romance);
        System.out.println(comedy);
        System.out.println(thriller);
        System.out.println(documentary);
    }


    
}
