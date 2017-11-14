/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsnext.pkg2.electric.boogaloo;

import javafx.scene.image.Image;

/**
 *
 * @author cxg5334
 */
public class Movie extends Media {
    private String ageRating;

    public Movie(String title, String genre, String description, int length, Image img, String ageRating, int rating) {
        super(title, genre, description, length, img, rating);
        this.ageRating = ageRating;
    }
    
    

    /**
     * @return the ageRating
     */
    public String getAgeRating() {
        return ageRating;
    }

    /**
     * @param ageRating the ageRating to set
     */
    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }
}
