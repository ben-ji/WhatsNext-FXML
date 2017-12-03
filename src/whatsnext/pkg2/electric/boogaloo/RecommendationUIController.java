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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Benjamin
 */
public class RecommendationUIController implements Initializable {

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
    private Button exitButton;
    @FXML
    private Button openSelectionButton;
    private Stage stage;
    private Parent root;
    private Scene scene;
    private ArrayList<Media> historyList = new ArrayList<Media>();
    private ObservableList<Media> observableMediaList;
    private ArrayList<Integer> intList = new ArrayList<Integer>();
    private ArrayList<String> genreList = new ArrayList<String>();
    private ArrayList<Media> mediaList = new ArrayList<Media>();
    private String primaryGenre;
    private String secondaryGenre;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(observableMediaList == null){
            observableMediaList = FXCollections.observableArrayList();
        }
        for(int i = 0; i < 6; i ++){
            intList.add(0);
        }
        genreList.add("Horror");
        genreList.add("Cartoon");
        genreList.add("Romance");
        genreList.add("Comedy");
        genreList.add("Thriller");
        genreList.add("Documentary");
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
        catch(IOException ex) {}
        catch(ClassNotFoundException e){}
        tallyGenres(historyList);
        primaryGenre = popHighestGenre();
        secondaryGenre = popHighestGenre();
        titleColumn.setCellValueFactory(new PropertyValueFactory<Media,String>("title"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<Media,String>("genre1"));
        subGenreColumn.setCellValueFactory(new PropertyValueFactory<Media,String>("genre2"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Media,String>("description"));
        resultsTable.setItems(observableMediaList);
        for(Media m : search(primaryGenre,secondaryGenre)){
            this.observableMediaList.add(m);
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

    private void tallyGenres(ArrayList<Media> mediaList) {
        int horror = 0;
        int cartoon = 0;
        int romance = 0;
        int comedy = 0;
        int thriller = 0;
        int documentary = 0;
        for(Media m : mediaList){
            switch(m.getGenre1()){
                case "Horror":
                    horror+= 2;
                case "Cartoon":
                    cartoon+= 2;
                case "Romance":
                    romance+= 2;
                case "Comedy":
                    comedy+= 2;
                case "Thriller":
                    thriller+= 2;
                case "Documentary":
                    documentary+= 2;
            }
            switch(m.getGenre2()){
                case "Horror":
                    horror++;
                case "Cartoon":
                    cartoon++;
                case "Romance":
                    romance++;
                case "Comedy":
                    comedy++;
                case "Thriller":
                    thriller++;
                case "Documentary":
                    documentary++;
            }    
        }
        intList.set(0, horror);
        intList.set(1, cartoon);
        intList.set(2, romance);
        intList.set(3, comedy);
        intList.set(4, thriller);
        intList.set(5, documentary);
    }

    private String popHighestGenre() {
        int hiIndex = 0;
        int hiNum = 0;
        String topGenre;
        for(int i = 0; i < intList.size(); i++){
            if(hiNum < intList.get(i)){
                hiNum = intList.get(i);
                hiIndex = i;
            }
        }
        topGenre = genreList.get(hiIndex);
        genreList.remove(hiIndex);
        intList.remove(hiIndex);
        return topGenre;
    }

    private ArrayList<Media> search(String primaryGenre, String secondaryGenre) {
        ArrayList<Media> returnList = new ArrayList<Media>();
        ArrayList<String> filters = new ArrayList<String>();
        filters.add(primaryGenre);
        filters.add(secondaryGenre);
        
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
        for(int i = 0; i < 20; i ++){
            tempGenre1 = genres.get(ThreadLocalRandom.current().nextInt(0, 6));
            tempGenre2 = genres.get(ThreadLocalRandom.current().nextInt(0, 6));
            tempTitle = "New Book" + (i+1);
            mediaList.add(new Book(tempTitle,tempGenre1, tempGenre2,"We think you'll love this Book!",99, "author", 10));
        }
        for(int i = 0; i < 20; i ++){
            tempGenre1 = genres.get((i+2) % 6);
            tempGenre2 = genres.get(((i+2)*i)%6);
            tempTitle = "New Movie" + (i+1);
            mediaList.add(new Movie(tempTitle,tempGenre1, tempGenre2,"We think you'll love this movie",99, "rating", 10));
        }
        
        for(Media m : mediaList){
            for(String f : filters){
                if(m.getGenre1().equalsIgnoreCase(f) || m.getGenre2().equalsIgnoreCase(f)){
                    returnList.add(m);
                    break;
                }
            }
        }
        return returnList;
    }


    
}
