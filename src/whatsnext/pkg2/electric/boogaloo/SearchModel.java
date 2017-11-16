/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsnext.pkg2.electric.boogaloo;

/**
 *
 * @author Benjamin
 */
public class SearchModel {
    
    private static SearchModel instance = null;
    
    public static SearchModel getInstance(){
        if(instance == null){
            instance = new SearchModel();
        }
        return instance;
    }
}
