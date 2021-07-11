package Package.FXML;

import Package.Classes.Admin;
import Package.IOOperator;
import Package.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class UserInfo implements Initializable {
    private final Main m = new Main();
    private Admin user;
    @FXML
    ListView userList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        populate(new ActionEvent());
    }

    @FXML
    private void populate(ActionEvent event) {
        user = IOOperator.readLoggedUser("src/Package/loggedUser.txt");
        userList.getItems().clear();
        userList.getItems().add(user.display());
    }

    @FXML
    public void switchToMain(ActionEvent event) throws Exception {
        m.changeScene("/Package/FXML/MainScreen2.fxml");
    }
}
