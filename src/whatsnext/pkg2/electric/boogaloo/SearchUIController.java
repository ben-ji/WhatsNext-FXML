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
import java.util.concurrent.ThreadLocalRandom;
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
import javafx.scene.image.Image;
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
    @FXML
    private CheckBox incognitoButton;
    

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
        ArrayList<Media> mediaList = new ArrayList<Media>();
        ArrayList<Media> resultsList = new ArrayList<Media>();
        ArrayList<Media> positiveList = new ArrayList<Media>();
        ArrayList<Media> negativeList = new ArrayList<Media>();
        //Constructing Dummy Data
        ArrayList<String> genres = new ArrayList<String>();
        genres.add("Horror");
        genres.add("Cartoon");
        genres.add("Romance");
        genres.add("Comedy");
        genres.add("Thriller");
        genres.add("Documentary");
        String tempTitle;
        String tempGenre1;
        String tempGenre2; 
        Stage stage = (Stage)searchButton.getScene().getWindow();
        for(int i = 0; i < 20; i ++){
            tempGenre1 = genres.get(ThreadLocalRandom.current().nextInt(0, 6));
            tempGenre2 = genres.get(ThreadLocalRandom.current().nextInt(0, 6));
            tempTitle = "Book" + (i+1);
            mediaList.add(new Book(tempTitle,tempGenre1, tempGenre2,"description",99, "author", 10));
        }
        for(int i = 0; i < 20; i ++){
            tempGenre1 = genres.get((i+2) % 6);
            tempGenre2 = genres.get(((i+2)*i)%6);
            tempTitle = "Movie" + (i+1);
            mediaList.add(new Movie(tempTitle,tempGenre1, tempGenre2,"description",99, "rating", 10));
        }
        
        //Determining what filters to use
        ArrayList<String> positives = new ArrayList<String>();
        ArrayList<String> negatives = new ArrayList<String>();
        ArrayList<CheckBox> posButtons = new ArrayList<CheckBox>();
        ArrayList<CheckBox> negButtons = new ArrayList<CheckBox>();
        posButtons.add(posHorror);
        posButtons.add(posCartoon);
        posButtons.add(posRomance);
        posButtons.add(posComedy);
        posButtons.add(posThriller);
        posButtons.add(posDocumentary);
        negButtons.add(negHorror);
        negButtons.add(negCartoon);
        negButtons.add(negRomance);
        negButtons.add(negComedy);
        negButtons.add(negThriller);
        negButtons.add(negDocumentary);
        for(int i = 0; i < 6; i++){
            if(posButtons.get(i).isSelected()){
                positives.add(posButtons.get(i).getText());
            }
            if(negButtons.get(i).isSelected()){
                negatives.add(negButtons.get(i).getText());
            }
        }
        
        
        //Getting Positive Results
        for(Media m : mediaList){
            for(String pos : positives){
                if(m.getGenre1().equalsIgnoreCase(pos) || m.getGenre2().equalsIgnoreCase(pos)){
                    positiveList.add(m);
                }
            }
        }
        //Getting Negative Results     
        for(Media m : mediaList){
            for(String neg : negatives){
                if(m.getGenre1().equalsIgnoreCase(neg) || m.getGenre2().equalsIgnoreCase(neg)){
                    negativeList.add(m);
                }
            }
        }
        //Combining Positive and Negative Lists to results
        for(Media p : positiveList){
            if((!negativeList.contains(p))&&(!resultsList.contains(p)))
                resultsList.add(p);
        }
        ResultCntl.getInstance(stage);
        ResultCntl.setMediaList(resultsList);

        //Writing to history if not in incognito mode:
        if(!incognitoButton.isSelected()){
            SearchCntl.getInstance(stage);
            SearchCntl.writeToHistory(resultsList);
        }
        
        try{
            root = FXMLLoader.load(getClass().getResource("ResultUI.fxml"));
        } catch(IOException ex){
            ex.printStackTrace();
        }
        SearchCntl.getInstance(stage).showResultUI(root,resultsList);
    }
}
