/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsnext.pkg2.electric.boogaloo;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Benjamin
 */
public class SearchUIController implements Initializable {

    @FXML
    private Button exitButton;
    private Stage stage;
    private Parent root;
    private Scene scene;
    @FXML
    private Button searchButton;
    @FXML
    private CheckBox posCartoon;
    @FXML
    private CheckBox posDocumentary;
    @FXML
    private CheckBox posComedy;
    @FXML
    private CheckBox posHorror;
    @FXML
    private CheckBox posRomance;
    @FXML
    private CheckBox posThriller;
    @FXML
    private CheckBox negCartoon;
    @FXML
    private CheckBox negDocumentary;
    @FXML
    private CheckBox negComedy;
    @FXML
    private CheckBox negHorror;
    @FXML
    private CheckBox negRomance;
    @FXML
    private CheckBox negThriller;
    private ObservableList<Media> mediaList;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mediaList = FXCollections.observableArrayList();
        
    }    

    @FXML
    private void showNavUI(ActionEvent event) {
        stage = (Stage)exitButton.getScene().getWindow();
        try{
            root = FXMLLoader.load(getClass().getResource("NavUI.fxml"));
        } catch(IOException ex){
            ex.printStackTrace();
        }
        SearchCntl.getInstance(stage).showNavUI(root);
    }

    @FXML
    private void search(ActionEvent event) {
        //Constructing Dummy Data
        ArrayList<Media> mediaList = new ArrayList<Media>();
        ArrayList<SimpleStringProperty> genres = new ArrayList<SimpleStringProperty>();
        String tempTitle;
        ArrayList<SimpleStringProperty> tempGenres = new ArrayList<SimpleStringProperty>();
        
        for(int i = 0; i < 20; i ++){
            tempTitle = "Book" + i;
            tempGenres.add(genres.get(i % 6));
            tempGenres.add(genres.get(i+i%6));
            //mediaList.add(new Book(tempTitle,tempGenres));
        }
    }
    
}
