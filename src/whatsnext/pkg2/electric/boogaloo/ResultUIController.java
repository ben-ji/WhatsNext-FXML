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
import javafx.collections.FXCollections;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dylan
 */
public class ResultUIController implements Initializable {
    
    @FXML
    private Button returnButton;
    private Stage stage;
    private Parent root;
    private Scene scene;
    @FXML
    private TableView<Media> resultsTable;
    @FXML
    private TableColumn<Media, String> titleColumn;
    @FXML
    private TableColumn<Media, String> genreColumn;
    @FXML
    private TableColumn<Media, String> subGenreColumn;
    @FXML
    private TableColumn<Media, String> descriptionColumn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<Media> al = ResultCntl.getMediaList();
        ObservableList<Media> listOfMedia = FXCollections.observableArrayList();
        for(Media m : al){
            listOfMedia.add(m);
        }
        titleColumn.setCellValueFactory(new PropertyValueFactory<Media,String>("title"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<Media,String>("genre1"));
        subGenreColumn.setCellValueFactory(new PropertyValueFactory<Media,String>("genre2"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Media,String>("description"));
        resultsTable.setItems(listOfMedia);
    }    
    
    @FXML
    private void showSearchUI(ActionEvent event) {
        stage = (Stage)returnButton.getScene().getWindow();
        try{
            root = FXMLLoader.load(getClass().getResource("SearchUI.fxml"));
        } catch(IOException ex){
            ex.printStackTrace();
        }
//        ResultCntl.getInstance(stage).showSearchUI(root, stage);
    }
}
