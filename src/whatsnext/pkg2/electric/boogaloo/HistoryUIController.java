/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsnext.pkg2.electric.boogaloo;

import java.io.IOException;
import java.net.URL;
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
 *
 * @author cxg5334
 */
public class HistoryUIController implements Initializable{
    @FXML
    private Button returnButton;
    private Stage stage;
    private Parent root;
    private Scene scene;
    @FXML
    private Button removeButton;
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
    @FXML
    private Button clearAllButton;
    private static ObservableList<Media> listOfMediaHistory;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(listOfMediaHistory == null){
            listOfMediaHistory = FXCollections.observableArrayList();
        }
        HistoryCntl.getInstance(stage);
        for(Media m : HistoryCntl.getMediaList()){
            listOfMediaHistory.add(m);
        }
        HistoryCntl.clearMediaList();
        titleColumn.setCellValueFactory(new PropertyValueFactory<Media,String>("title"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<Media,String>("genre1"));
        subGenreColumn.setCellValueFactory(new PropertyValueFactory<Media,String>("genre2"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Media,String>("description"));
        resultsTable.setItems(listOfMediaHistory);
    }    
    
    @FXML
    private void showProfileUI(ActionEvent event){
        stage= (Stage)returnButton.getScene().getWindow();
        try {
            root = FXMLLoader.load(getClass().getResource("ProfileUI.fxml"));
        } catch(IOException ex){
            ex.printStackTrace();
        }
        HistoryCntl.getInstance(stage).showProfileUI(root, stage);
    }

    @FXML
    private void removeSelectedMedia(ActionEvent event) {
        Media tempMedia = resultsTable.getSelectionModel().getSelectedItem();
        for(int i = 0; i < listOfMediaHistory.size(); i ++){
            if(listOfMediaHistory.get(i).getTitle().equals(tempMedia.getTitle())){
                listOfMediaHistory.remove(i);
                break;
            }   
        }
        HistoryCntl.updateMediaListFile();
    }

    @FXML
    private void clearAllHistory(ActionEvent event) {
        listOfMediaHistory.clear();
        HistoryCntl.updateMediaListFile();
    }
    
}
