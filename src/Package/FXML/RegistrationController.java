package Package.FXML;

import Package.Classes.Admin;
import Package.IOOperator;
import Package.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class RegistrationController {
    private ArrayList<Admin> accountList = new ArrayList<>();
    private Main m = new Main();
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    TextField name;
    @FXML
    TextField email;
    @FXML
    Label error;

    public void register(ActionEvent event) throws Exception {
        accountList = IOOperator.readAdminUser("src/Package/user.txt");
        for (Admin admin : accountList) {
            if (admin.getUsername().equals(username.getText())) {
                error.setStyle("-fx-text-fill: Red");
                error.setText("Username Already Exist");
                return;
            }
        }
        accountList.add(new Admin(username.getText(), password.getText(),name.getText(),email.getText()));
        IOOperator.writeAdmin("src/Package/user.txt", accountList);
        switchToMain(event);
    }
    @FXML
    public void switchToMain(ActionEvent event) throws Exception {
        m.changeScene("/Package/FXML/MainScreen2.fxml");
    }
}
