package Package.FXML;

import Package.Classes.Admin;
import Package.IOOperator;
import Package.Classes.NhanVien;
import Package.Main;
import Package.QLNV;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class StatusScreenController {
    private final Main m = new Main();
    @FXML
    TextField name;
    @FXML
    TextField index;
    @FXML
    ListView list;

    private Admin user;

    public void search(ActionEvent event) {
        searchEmployee(name, list);
    }

    static void searchEmployee(TextField employeeName, ListView employeeList) {
        String name = employeeName.getText();
        employeeList.getItems().clear();
        for (int i = 0; i < QLNV.CodeGym.size(); i++) {
            if (QLNV.CodeGym.get(i).getName().equals(name)) {
                employeeList.getItems().add(QLNV.CodeGym.get(i) + " Index: " + i);
            }
        }
    }

    public void showAll(ActionEvent event) {
        showAll(list);
    }

    static void showAll(ListView list) {
        list.getItems().clear();
        for (NhanVien N : QLNV.CodeGym) {
            list.getItems().add(N);
        }
    }


    public void restAll(ActionEvent event) {
        for (NhanVien N : QLNV.CodeGym) {
            N.setStatus(false);
        }
        IOOperator.writeToFile("src/Package/list.txt", QLNV.CodeGym);
    }

    public void rest(ActionEvent event) {
        QLNV.CodeGym.get(Integer.parseInt(index.getText())).setStatus(false);
        IOOperator.writeToFile("src/Package/list.txt", QLNV.CodeGym);
    }

    public void workAll(ActionEvent event) {
        for (NhanVien N : QLNV.CodeGym) {
            N.setStatus(true);
        }
        IOOperator.writeToFile("src/Package/list.txt", QLNV.CodeGym);
    }

    public void Work(ActionEvent event) {
        QLNV.CodeGym.get(Integer.parseInt(index.getText())).setStatus(true);
        IOOperator.writeToFile("src/Package/list.txt", QLNV.CodeGym);
    }

    @FXML
    public void switchToMain(ActionEvent event) throws Exception {
        user = IOOperator.readLoggedUser("src/Package/loggedUser.txt");
        if (user.getName().equalsIgnoreCase("admin")) {
            m.changeScene("/Package/FXML/MainScreen.fxml");
        }else {
            m.changeScene("/Package/FXML/MainScreen2.fxml");
        }
    }
}
