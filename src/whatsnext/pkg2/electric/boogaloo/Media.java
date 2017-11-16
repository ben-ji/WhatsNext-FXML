/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsnext.pkg2.electric.boogaloo;

import javafx.scene.image.Image;
import javafx.beans.property.SimpleStringProperty;
/**
 *
 * @author cxg5334
 */
public abstract class Media {
    private SimpleStringProperty title = new SimpleStringProperty();
    private SimpleStringProperty genre = new SimpleStringProperty();
    private SimpleStringProperty description = new SimpleStringProperty();
    private int length;
    private Image img;
    private int rating;
    
    public Media(String newTitle, String newGenre, String newDescription, int length, Image img, int rating){
        title.set(newTitle);
        genre.set(newGenre);
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
    public String getGenre() {
        return genre.get();
    }

    /**
     * @param newGenre
     */
    public void setGenre(String newGenre) {
        genre.set(newGenre);
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
        genre.set(newDescription);
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
     * @param genre the genre to set
     */
    public void setGenre(SimpleStringProperty genre) {
        this.genre = genre;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(SimpleStringProperty description) {
        this.description = description;
    }
    
}

