package Package.FXML;

import Package.IOOperator;
import Package.Main;
import Package.QLNV;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class DeleteScreenController {
    private final Main m = new Main();
    @FXML
    TextField employeeName;
    @FXML
    ListView employeeList;
    @FXML
    TextField employeeIndex;

    public void search(ActionEvent event) {
        SearchScreenController.searchEmployee(employeeName, employeeList);
    }

    public void delete(ActionEvent event) throws Exception {
        int index = Integer.parseInt(employeeIndex.getText());
        QLNV.CodeGym.remove(index);
        IOOperator.writeToFile("src/Package/list.txt", QLNV.CodeGym);
        switchToDelete(event);
    }

    @FXML
    public void switchToMain(ActionEvent event) throws Exception {
        m.changeScene("/Package/FXML/MainScreen.fxml");
    }

    public void switchToDelete(ActionEvent event) throws Exception {
        m.changeScene("/Package/FXML/DeleteScreenConfirm.fxml");
    }
}
