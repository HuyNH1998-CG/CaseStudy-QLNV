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
    private final Main m = new Main();

    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    Label errMess;


    public void register(ActionEvent event){
        accountList = IOOperator.readAdminUser("src/Package/user.txt");
        for(Admin admin : accountList){
            if(admin.getUsername().equals(username.getText())){
                errMess.setText("User Already Exist");
                return;
            }
        }
        accountList.add(new Admin(username.getText(),password.getText()));
        IOOperator.writeAdmin("src/Package/user.txt",accountList);
    }
    public void login(ActionEvent event) throws IOException {
        if (username.getText().equals("") || password.getText().equals("")){
            errMess.setStyle("-fx-text-fill: red");
            errMess.setText("User not found or invalid data");
            return;
        }
        accountList = IOOperator.readAdminUser("src/Package/user.txt");
        for (Admin admin : accountList){
            if(admin.getUsername().equals(username.getText())&&admin.getPassword().equals(password.getText())){
                IOOperator.getLoggedUser("src/Package/loggedUser.txt",admin);
                m.changeScene("/Package/FXML/MainScreen.fxml");
            } else {
                errMess.setStyle("-fx-text-fill: red");
                errMess.setText("Wrong Username or Password");
            }
        }
    }
}
