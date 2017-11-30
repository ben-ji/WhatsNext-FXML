/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsnext.pkg2.electric.boogaloo;

import java.io.Serializable;
import javafx.scene.image.Image;
/**
 *
 * @author cxg5334
 */
public abstract class Media implements Serializable{
    private String title;
    private String genre1;
    private String genre2;
    private String description;
    private int length;
    private int rating;
    
    public Media(String title, String genre1, String genre2, String description, int length, int rating){
        this.title = title;
        this.genre1 = genre1;
        this.genre2 = genre2;
        this.description=description;
        this.length = length;
        this.rating = rating;
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
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the genre1
     */
    public String getGenre1() {
        return genre1;
    }

    /**
     * @param genre1 the genre1 to set
     */
    public void setGenre1(String genre1) {
        this.genre1 = genre1;
    }

    /**
     * @return the genre2
     */
    public String getGenre2() {
        return genre2;
    }

    /**
     * @param genre2 the genre2 to set
     */
    public void setGenre2(String genre2) {
        this.genre2 = genre2;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}


