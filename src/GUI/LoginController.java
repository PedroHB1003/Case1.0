package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;


public class LoginController implements Initializable {
    
    @FXML
    private Button btnLogin;

    @FXML
    private TextField Login_user;
    
    @FXML
    private PasswordField Login_Password;

    
    public void goDownload(ActionEvent event) throws IOException {
        Parent downloadParent = FXMLLoader.load(getClass().getResource("Download.fxml"));
        Scene downloadScene = new Scene(downloadParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(downloadScene);
        window.show();
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
