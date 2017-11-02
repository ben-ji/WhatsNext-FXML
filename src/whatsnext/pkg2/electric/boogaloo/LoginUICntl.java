/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsnext.pkg2.electric.boogaloo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;

/**
 *
 * @author daw5510
 */
public class LoginUICntl implements Initializable {
    
    @FXML
    private PasswordField pf;
    @FXML
    private PasswordField uf;
    UserList ul;
    
        private Boolean checkUsers(UserList ul){
        for(int i = 0; i < ul.getUserList().size(); i++){
            if((uf.getText().equals(ul.get(i).getUsername()))&&(pf.getText().equals(ul.get(i).getPassword()))){
                return true;
            }
        }
        return false;
    }
    
    @FXML
    private void authenticate(ActionEvent event) {
        //TODO: Professor Haynes says we will be using persistent data later in the course. For this reason, test data will be hardcoded for the login process for the time being.
        ul = new UserList();
        ul.add(new User("admin", "password"));
        ul.add(new User("kats", "cream"));
        if(checkUsers(ul)){
            System.out.println("User validated");
        }
        else{
            System.out.println("User invalid.");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
}
