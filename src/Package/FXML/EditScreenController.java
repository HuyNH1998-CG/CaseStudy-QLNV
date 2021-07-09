package Package.FXML;

import Package.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class EditScreenController {
    private final Main m = new Main();
    @FXML
    TextField employeeName;
    @FXML
    ListView employeeList;
    @FXML
    TextField employeeIndex;

    @FXML
    static int index;


    @FXML
    public void switchToMain(ActionEvent event) throws Exception {
        m.changeScene("/Package/FXML/MainScreen2.fxml");
    }

    @FXML
    public void switchToEditMain(ActionEvent event) throws Exception {
        m.changeScene("/Package/FXML/EditScreen.fxml");
    }


    public void search(ActionEvent event) {
        SearchScreenController.searchEmployee(employeeName, employeeList);
    }


    public void goToEdit(ActionEvent event) throws Exception {
        index = Integer.parseInt(employeeIndex.getText());
        switchToEditMain(event);
    }

}
