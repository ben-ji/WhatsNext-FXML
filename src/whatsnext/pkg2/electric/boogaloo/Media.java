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
    private SimpleStringProperty genre1 = new SimpleStringProperty();
    private SimpleStringProperty genre2 = new SimpleStringProperty();
    private SimpleStringProperty description = new SimpleStringProperty();
    private int length;
    private Image img;
    private int rating;
    
    public Media(String title, String genre1, String genre2, String description, int length, Image img, int rating){
        this.title.set(title);
        this.genre1.set(genre1);
        this.genre2.set(genre2);
        this.description.set(description);
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

    /**
     * @return the genre
     */

    /**
     * @return the description
     */
    public String getDescription() {
        return description.get();
    }

    /**
     * @param newDescription
     */

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

    /**
     * @return the genre1
     */
    public SimpleStringProperty getGenre1() {
        return genre1;
    }

    /**
     * @param genre1 the genre1 to set
     */
    public void setGenre1(SimpleStringProperty genre1) {
        this.genre1 = genre1;
    }

    /**
     * @return the genre2
     */
    public SimpleStringProperty getGenre2() {
        return genre2;
    }

    /**
     * @param genre2 the genre2 to set
     */
    public void setGenre2(SimpleStringProperty genre2) {
        this.genre2 = genre2;
    }
    
}

