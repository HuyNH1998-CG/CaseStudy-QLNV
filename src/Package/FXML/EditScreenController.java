package Package.FXML;

import Package.Classes.NhanVien;
import Package.Classes.NhanVienDaoTaoPartTime;
import Package.Classes.NhanVienTuyenSinh;
import Package.IOOperator;
import Package.Main;
import Package.QLNV;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.Locale;

import static Package.FXML.AddScreenController.getNhanVien;

public class EditScreenController {
    private final Main m = new Main();
    @FXML
    TextField employeeName;
    @FXML
    ListView employeeList;
    @FXML
    TextField employeeIndex;
    @FXML
    TextField name;
    @FXML
    TextField age;
    @FXML
    TextField gender;
    @FXML
    TextField phone;
    @FXML
    TextField email;
    @FXML
    TextField salary;
    @FXML
    TextField others;
    @FXML
    ChoiceBox<String> typeBox;
    ObservableList<String> choices = FXCollections.observableArrayList("Dao Tao Full-Time", "Dao Tao Part-Time", "Tuyen Sinh");

    @FXML
    static int index;

    @FXML
    public void setTypeBox(MouseEvent event) {
        typeBox.setItems(choices);
    }

    @FXML
    public void switchToMain(ActionEvent event) throws Exception {
        m.changeScene("/Package/FXML/MainScreen.fxml");
    }

    @FXML
    public void switchToEditMain(ActionEvent event) throws Exception {
        m.changeScene("/Package/FXML/EditScreen.fxml");
    }

    @FXML
    public void switchToEditSearch(ActionEvent event) throws Exception {
        m.changeScene("/Package/FXML/EditScreenSearch.fxml");
    }

    public void search(ActionEvent event) {
        SearchScreenController.searchEmployee(employeeName, employeeList);
    }
    public void getInfo(ActionEvent event){
        name.setText(QLNV.CodeGym.get(index).getName());
        age.setText(QLNV.CodeGym.get(index).getAge());
        gender.setText(QLNV.CodeGym.get(index).getGender());
        phone.setText(QLNV.CodeGym.get(index).getSdt());
        email.setText(QLNV.CodeGym.get(index).getEmail());
        salary.setText(String.valueOf(QLNV.CodeGym.get(index).getSalary()));
        if (QLNV.CodeGym.get(index) instanceof NhanVienTuyenSinh) {
            typeBox.setValue("Tuyen Sinh");
            others.setText(String.valueOf(((NhanVienTuyenSinh) QLNV.CodeGym.get(index)).getRecruitedAmount()));
        } else if (QLNV.CodeGym.get(index) instanceof NhanVienDaoTaoPartTime) {
            typeBox.setValue("Dao Tao Part-Time");
            others.setText(String.valueOf(((NhanVienDaoTaoPartTime) QLNV.CodeGym.get(index)).getHourWorked()));
        } else {
            typeBox.setValue("Dao Tao Full-Time");
        }
    }

    public void goToEdit(ActionEvent event) throws Exception {
        index = Integer.parseInt(employeeIndex.getText());
        switchToEditMain(event);
    }

    @FXML
    public void edit(ActionEvent event) throws Exception {
        NhanVien tempEmployee = createNhanVien(event);
        if (tempEmployee != null) {
            QLNV.CodeGym.set(index, tempEmployee);
            IOOperator.writeToFile("E:\\firstFX\\src\\Package\\list.txt", QLNV.CodeGym);
            m.changeScene("/Package/FXML/MainScreen.fxml");
        }
    }

    @FXML
    public void ageValidator(KeyEvent event) {
        if (!age.getText().matches("^\\d+$")) {
            age.setStyle("-fx-text-fill: red");
        } else {
            age.setStyle("-fx-text-fill: green");
        }
    }

    @FXML
    public void genderValidator(KeyEvent event) {
        if (!gender.getText().matches("^[Nn][aA][mM]+|[Nn][uU]$")) {
            gender.setStyle("-fx-text-fill: red");
        } else {
            gender.setStyle("-fx-text-fill: green");
        }
    }

    @FXML
    public void phoneValidator(KeyEvent event) {
        isValid(phone);
    }

    static void isValid(TextField phone) {
        if (!phone.getText().matches("\\d{2}-[0]\\d{9}")) {
            phone.setStyle("-fx-text-fill: red");
        } else {
            phone.setStyle("-fx-text-fill: green");
            for(NhanVien N : QLNV.CodeGym){
                if(N.getSdt().equals(phone.getText())){
                    phone.setStyle("-fx-text-fill: red");
                }
            }
        }
    }

    @FXML
    public void emailValidator(KeyEvent event) {
        isMailValid(email);
    }

    static void isMailValid(TextField email) {
        if (!email.getText().matches("^\\w+@\\w+(\\.\\w+)$")) {
            email.setStyle("-fx-text-fill: red");
        } else {
            email.setStyle("-fx-text-fill: green");
            for(NhanVien N : QLNV.CodeGym){
                if(N.getEmail().toLowerCase(Locale.ROOT).equals(email.getText().toLowerCase(Locale.ROOT))){
                    email.setStyle("-fx-text-fill: red");
                }
            }
        }
    }

    @FXML
    public void salaryValidator(KeyEvent event) {
        if (!salary.getText().matches("^\\d+$")) {
            salary.setStyle("-fx-text-fill: red");
        } else {
            salary.setStyle("-fx-text-fill: green");
        }
    }

    @FXML
    public void otherValidator(KeyEvent event) {
        if (!others.getText().matches("^\\d+$")) {
            others.setStyle("-fx-text-fill: red");
        } else {
            others.setStyle("-fx-text-fill: green");
        }
    }

    @FXML
    public NhanVien createNhanVien(ActionEvent event) {
        try {
            return getNhanVien(name, age, gender, phone, email, salary, typeBox, others);
        } catch (Exception e) {
            try {
                m.changeScene("/Package/FXML/EditScreenError.fxml");
            } catch (IOException ioException) {
                System.err.println("An Error Has Occur");
            }

        }
        return null;
    }
}
