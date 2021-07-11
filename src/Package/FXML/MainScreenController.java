package Package.FXML;

import Package.Classes.Admin;
import Package.Classes.NhanVien;
import Package.IOOperator;
import Package.Main;
import Package.QLNV;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.IOException;

public class MainScreenController {
    private Admin user;
    private final Main m = new Main();
    @FXML
    ListView listView = new ListView();

    @FXML
    private void populate(ActionEvent event) {
        listView.getItems().clear();
        for (NhanVien N : QLNV.CodeGym) {
            listView.getItems().add(N);
        }
    }


    @FXML
    public void switchToAdd(ActionEvent event) throws Exception {
        m.changeScene("/Package/FXML/AddScreen.fxml");
    }

    @FXML
    public void switchToRemove(ActionEvent event) throws Exception {
        m.changeScene("/Package/FXML/DeleteScreen.fxml");
    }

    @FXML
    public void switchToEdit(ActionEvent event) throws Exception {
        m.changeScene("/Package/FXML/EditScreenSearch.fxml");
    }

    @FXML
    public void switchToSearch(ActionEvent event) throws Exception {
        m.changeScene("/Package/FXML/SearchScreen.fxml");
    }

    @FXML
    public void switchToStatus(ActionEvent event) throws Exception {
        m.changeScene("/Package/FXML/StatusScreen.fxml");
    }

    public void sort(ActionEvent event) {
        QLNV.sortByName();
        listView.getItems().clear();
        for (NhanVien N : QLNV.CodeGym) {
            listView.getItems().add(N);
        }
    }

    public void getCurrentUser() {
        try {
            m.changeScene("/Package/FXML/UserInfo.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void logOut(ActionEvent event) throws Exception {
        user = null;
        IOOperator.getLoggedUser("src/Package/loggedUser.txt", null);
        m.changeScene("/Package/FXML/LoginScreen.fxml");

    }
}
