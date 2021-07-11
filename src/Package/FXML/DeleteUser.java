package Package.FXML;

import Package.Classes.Admin;
import Package.IOOperator;
import Package.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DeleteUser implements Initializable {
    private final Main m = new Main();
    private ArrayList<Admin> accountList = new ArrayList<>();
    @FXML
    ListView userList;

    @FXML
    TextField userIndex;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        populate(new ActionEvent());
    }

    @FXML
    private void populate(ActionEvent event) {
        accountList = IOOperator.readAdminUser("src/Package/user.txt");
        userList.getItems().clear();
        for (int i =0; i < accountList.size(); i++){
            userList.getItems().add(accountList.get(i).display() + ", Index: " + i);
        }
    }

    public void delete(ActionEvent event) throws Exception {
        int index = Integer.parseInt(userIndex.getText());
        accountList.remove(index);
        IOOperator.writeAdmin("src/Package/user.txt.txt", accountList);
        populate(event);
        switchToDeleteUserConfirm(event);
    }

    @FXML
    public void switchToMain(ActionEvent event) throws Exception {
        m.changeScene("/Package/FXML/MainScreen2.fxml");
    }

    @FXML
    public void switchToDeleteUser(ActionEvent event) throws Exception {
        m.changeScene("/Package/FXML/DeleteUser.fxml");
    }

    @FXML
    public void switchToDeleteUserConfirm(ActionEvent event) throws Exception {
        m.changeScene("/Package/FXML/DeleteUserConfirm.fxml");
    }
}
