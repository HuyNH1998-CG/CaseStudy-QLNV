package Package.FXML;

import Package.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class DeleteUserConfirm {
    private final Main m = new Main();
    @FXML
    public void switchToMain(ActionEvent event) throws Exception {
        m.changeScene("/Package/FXML/MainScreen2.fxml");
    }

    @FXML
    public void switchToDeleteUser(ActionEvent event) throws Exception {
        m.changeScene("/Package/FXML/DeleteUser.fxml");
    }
}
