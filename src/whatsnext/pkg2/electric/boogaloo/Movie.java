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
public class Movie extends Media {
    private SimpleStringProperty ageRating = new SimpleStringProperty();

    public Movie(String title, String genre, String description, int length, Image img, String newAgeRating, int rating) {
        super(title, genre, description, length, img, rating);
        ageRating.set(newAgeRating);
    }
    
    

    /**
     * @return the ageRating
     */
    public String getAgeRating() {
        return ageRating.get();
    }

    /**
     * @param newAgeRating
     */
    public void setAgeRating(String newAgeRating) {
        ageRating.set(newAgeRating);
    }
}
