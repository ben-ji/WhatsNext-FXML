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
public class Movie extends Media implements Serializable{
    private String ageRating;

    public Movie(String title,String genre1, String genre2, String description, int length, String newAgeRating, int rating) {
        super(title, genre1, genre2, description, length, rating);
        ageRating=newAgeRating;
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
