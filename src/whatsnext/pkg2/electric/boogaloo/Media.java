/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsnext.pkg2.electric.boogaloo;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.beans.property.SimpleStringProperty;
/**
 *
 * @author cxg5334
 */
public abstract class Media {
    private SimpleStringProperty title = new SimpleStringProperty();
    private ArrayList<SimpleStringProperty> genres;
    private SimpleStringProperty description = new SimpleStringProperty();
    private int length;
    private Image img;
    private int rating;
    
    public Media(String newTitle, ArrayList<SimpleStringProperty> genres, String newDescription, int length, Image img, int rating){
        this.title.set(newTitle);
        this.genres = genres;
        description.set(newDescription);
        this.length = length;
        this.img = img;
        this.rating = rating;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title.get();
    }

    /**
     * @param newTitle
     */
    public void setTitle(String newTitle) {
        title.set(newTitle);
    }

    /**
     * @return the genre
     */
    public ArrayList<SimpleStringProperty> getGenre() {
        return genres;
    }

    /**
     * @param newGenre
     */
    public void setGenres(ArrayList<SimpleStringProperty> genres) {
        this.genres = genres;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description.get();
    }

    /**
     * @param newDescription
     */
    public void setDescription(String newDescription) {
        this.description.set(newDescription);
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * @return the img
     */
    public Image getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(Image img) {
        this.img = img;
    }

    /**
     * @return the rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(SimpleStringProperty title) {
        this.title = title;
    }


    /**
     * @param description the description to set
     */
    public void setDescription(SimpleStringProperty description) {
        this.description = description;
    }
    
}

