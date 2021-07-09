package Package.FXML;

import Package.Classes.NhanVien;
import Package.Classes.NhanVienDaoTaoFullTime;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class AddScreenController {
    private final Main m = new Main();

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
    @FXML
    Label reminder;
    ObservableList<String> choices = FXCollections.observableArrayList("Dao Tao Full-Time", "Dao Tao Part-Time", "Tuyen Sinh");

    @FXML
    public void setTypeBox(MouseEvent event) {
        typeBox.setItems(choices);
    }

    @FXML
    public void switchToMain(ActionEvent event) throws Exception {
        m.changeScene("/Package/FXML/MainScreen2.fxml");
    }

    @FXML
    public void switchToAdd(ActionEvent event) throws Exception {
        m.changeScene("/Package/FXML/AddScreen.fxml");
    }

    @FXML
    public void add(ActionEvent event) throws Exception {
        NhanVien tempEmployee = createNhanVien(event);
        if (tempEmployee != null) {
            QLNV.CodeGym.add(tempEmployee);
            IOOperator.writeToFile("src/Package/list.txt", QLNV.CodeGym);
            m.changeScene("/Package/FXML/AddScreenConfirm.fxml");
        }
    }

    public void remind(MouseEvent event) {
        if(typeBox.getValue()!=null){
            if (typeBox.getValue().equals("Dao Tao Part-Time")){
                reminder.setStyle("-fx-text-fill: red");
                reminder.setText("Input hours that this worker have worked into \"Others\"");

            } else if (typeBox.getValue().equals("Tuyen Sinh")){
                reminder.setStyle("-fx-text-fill: red");
                reminder.setText("Input amount of student that this worker have recruited into \"Others\"");
            } else {
                reminder.setText(null);
            }
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
        EditController.isValid(phone);
    }

    @FXML
    public void emailValidator(KeyEvent event) {
        EditController.isMailValid(email);
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
                m.changeScene("/Package/FXML/AddScreenError.fxml");
            } catch (IOException ioException) {
                System.err.println("Error");
            }

        }
        return null;
    }

    static NhanVien getNhanVien(TextField name, TextField age, TextField gender, TextField phone, TextField email, TextField salary, ChoiceBox<String> typeBox, TextField others) {
        String employeeName = name.getText();
        String employeeAge = age.getText();
        String employeeGender = gender.getText();
        String employeePhone = phone.getText();
        String employeeEmail = email.getText();
        long employeeSalary = Long.parseLong(salary.getText());
        if (typeBox.getValue().equals("Tuyen Sinh")) {
            long other = Long.parseLong(others.getText());
            return new NhanVienTuyenSinh(employeeName, employeeAge, employeeGender, employeePhone, employeeEmail, employeeSalary, other);
        } else if (typeBox.getValue().equals("Dao Tao Part-Time")) {
            long other = Long.parseLong(others.getText());
            return new NhanVienDaoTaoPartTime(employeeName, employeeAge, employeeGender, employeePhone, employeeEmail, employeeSalary, other);
        } else {
            return new NhanVienDaoTaoFullTime(employeeName, employeeAge, employeeGender, employeePhone, employeeEmail, employeeSalary);
        }
    }
}
