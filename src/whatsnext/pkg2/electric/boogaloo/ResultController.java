/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsnext.pkg2.electric.boogaloo;

import java.util.ArrayList;

/**
 *
 * @author Dylan
 */
public class ResultController {
    private static ArrayList<Media> mediaList;

    /**
     * @return the mediaList
     */
    public static ArrayList<Media> getMediaList() {
        return mediaList;
    }

    /**
     * @param aMediaList the mediaList to set
     */
    public static void setMediaList(ArrayList<Media> aMediaList) {
        mediaList = aMediaList;
    }
    
}
