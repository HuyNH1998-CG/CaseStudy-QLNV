package Package.FXML;

import Package.Classes.Admin;
import Package.Classes.NhanVien;
import Package.Classes.NhanVienDaoTaoPartTime;
import Package.IOOperator;
import Package.Main;
import Package.QLNV;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenControllers implements Initializable {
    private Admin user;
    private final Main m = new Main();
    @FXML
    TableView<NhanVien> table = new TableView<>();
    @FXML
    TableColumn<NhanVien, String> tableName = new TableColumn<>();
    @FXML
    TableColumn<NhanVien, String> tableAge = new TableColumn<>();
    @FXML
    TableColumn<NhanVien, String> tableGender = new TableColumn<>();
    @FXML
    TableColumn<NhanVien, String> tablePhone = new TableColumn<>();
    @FXML
    TableColumn<NhanVien, String> tableEmail = new TableColumn<>();
    @FXML
    TableColumn<NhanVien, Long> tableSalary = new TableColumn<>();
    @FXML
    TableColumn<NhanVien, Long> tableTotalSal = new TableColumn<>();
    @FXML
    TableColumn<NhanVien, Boolean> tableStatus = new TableColumn<>();
    @FXML
    TableColumn<NhanVien, Long> tableOthers = new TableColumn<>();

    ObservableList<NhanVien> list = getList();

    private ObservableList<NhanVien> getList() {
        ObservableList<NhanVien> list = FXCollections.observableArrayList();
        list.addAll(QLNV.CodeGym);
        return list;
    }

    @FXML
    public void populate(ActionEvent event) {
        tableName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        tableGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        tablePhone.setCellValueFactory(new PropertyValueFactory<>("sdt"));
        tableEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        tableTotalSal.setCellValueFactory(new PropertyValueFactory<>("totalSalary"));
        tableStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        tableOthers.setCellValueFactory(new PropertyValueFactory<>("others"));
        table.setItems(list);
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

    @FXML
    public void addNewAdmin(ActionEvent event) throws Exception {
        m.changeScene("/Package/FXML/Registration.fxml");
    }

    @FXML
    public void removeAdminAccount(ActionEvent event) throws Exception {
        m.changeScene("/Package/FXML/DeleteUser.fxml");
    }

    public void sort(ActionEvent event) {
        QLNV.sortByName();
        table.getItems().clear();
        for (NhanVien N : QLNV.CodeGym) {
            table.getItems().add(N);
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ActionEvent event = new ActionEvent();
        populate(event);
    }
}
