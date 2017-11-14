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
public class Book extends Media{
    private String author;
    
    public Book(String title, String genre, String description, int length, Image img, String author, int rating) {
        super(title, genre, description, length, img, rating);
        this.author = author;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }
    
}
