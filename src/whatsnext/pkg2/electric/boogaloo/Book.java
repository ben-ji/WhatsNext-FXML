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
public class Book extends Media{
    private SimpleStringProperty author;
    
    public Book(String title, String genre, String description, int length, Image img, String newAuthor, int rating) {
        super(title, genre, description, length, img, rating);
        author.set(newAuthor);
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author.get();
    }

    /**
     * @param newAuthor
     */
    public void setAuthor(String newAuthor) {
        author.set(newAuthor);
    }
    
}
