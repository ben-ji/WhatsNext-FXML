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


    
}
