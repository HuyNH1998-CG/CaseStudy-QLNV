package Package.FXML;


import Package.Classes.Admin;
import Package.IOOperator;
import Package.Main;
import Package.QLNV;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class SearchScreenController {
    private final Main m = new Main();
    @FXML
    TextField employeeName;
    @FXML
    ListView employeeList;
    private Admin user;
    public void search(ActionEvent event) {
        searchEmployee(employeeName, employeeList);
    }

    static void searchEmployee(TextField employeeName, ListView employeeList) {
        String name = employeeName.getText();
        employeeList.getItems().clear();
        for (int i = 0; i < QLNV.CodeGym.size(); i++) {
            if (QLNV.CodeGym.get(i).getName().contains(name)) {
                employeeList.getItems().add(QLNV.CodeGym.get(i) + " Index: " + i);
            }
        }
    }

    @FXML
    public void switchToMain(ActionEvent event) throws Exception {
        user = IOOperator.readLoggedUser("src/Package/loggedUser.txt");
        if (user.getName().equalsIgnoreCase("admin")) {
            m.changeScene("/Package/FXML/MainScreen2.fxml");
        }else {
            m.changeScene("/Package/FXML/MainScreen.fxml");
        }
    }
}
