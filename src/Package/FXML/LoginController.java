package Package.FXML;

import Package.Classes.Admin;
import Package.IOOperator;
import Package.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class LoginController {
    private ArrayList<Admin> accountList = new ArrayList<>();
    private Main m = new Main();
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    Label errMess;
    private final String admin = "admin";
    private final String adminPassword = "admin@9152";

    public void login(ActionEvent event) throws IOException {
        if (username.getText().equals("") || password.getText().equals("")){
            errMess.setStyle("-fx-text-fill: red");
            errMess.setText("User not found or invalid data");
            return;
        }
        if(username.getText().equalsIgnoreCase(admin) && password.getText().equals(adminPassword)){
            IOOperator.getLoggedUser("src/Package/loggedUser.txt",new Admin(admin,adminPassword,"admin","admin"));
            m.changeScene2("/Package/FXML/MainScreen2.fxml");
        }else {
            accountList = IOOperator.readAdminUser("src/Package/user.txt");
            for (Admin admin : accountList){
                if(admin.getUsername().equals(username.getText())&&admin.getPassword().equals(password.getText())){
                    IOOperator.getLoggedUser("src/Package/loggedUser.txt",admin);
                    m.changeScene2("/Package/FXML/MainScreen2.fxml");
                } else {
                    errMess.setStyle("-fx-text-fill: red");
                    errMess.setText("Wrong Username or Password");
                }
            }
        }
    }
}
