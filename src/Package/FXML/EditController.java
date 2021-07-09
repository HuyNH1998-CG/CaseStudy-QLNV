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
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import static Package.FXML.AddScreenController.getNhanVien;

public class EditController implements Initializable {
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
    ObservableList<String> choices = FXCollections.observableArrayList("Dao Tao Full-Time", "Dao Tao Part-Time", "Tuyen Sinh");

    @FXML
    public void setTypeBox(MouseEvent event) {
        typeBox.setItems(choices);
    }

    public void getInfo(ActionEvent event) {
        name.setText(QLNV.CodeGym.get(EditScreenController.index).getName());
        age.setText(QLNV.CodeGym.get(EditScreenController.index).getAge());
        gender.setText(QLNV.CodeGym.get(EditScreenController.index).getGender());
        phone.setText(QLNV.CodeGym.get(EditScreenController.index).getSdt());
        email.setText(QLNV.CodeGym.get(EditScreenController.index).getEmail());
        salary.setText(String.valueOf(QLNV.CodeGym.get(EditScreenController.index).getSalary()));
        if (QLNV.CodeGym.get(EditScreenController.index) instanceof NhanVienTuyenSinh) {
            typeBox.setValue("Tuyen Sinh");
            others.setText(String.valueOf(QLNV.CodeGym.get(EditScreenController.index).getOthers()));
        } else if (QLNV.CodeGym.get(EditScreenController.index) instanceof NhanVienDaoTaoPartTime) {
            typeBox.setValue("Dao Tao Part-Time");
            others.setText(String.valueOf(QLNV.CodeGym.get(EditScreenController.index).getOthers()));
        } else {
            typeBox.setValue("Dao Tao Full-Time");
        }
    }

    @FXML
    public void edit(ActionEvent event) throws Exception {
        NhanVien tempEmployee = createNhanVien(event);
        if (tempEmployee != null) {
            QLNV.CodeGym.set(EditScreenController.index, tempEmployee);
            IOOperator.writeToFile("src/Package/list.txt", QLNV.CodeGym);
            m.changeScene("/Package/FXML/MainScreen2.fxml");
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
            for (NhanVien N : QLNV.CodeGym) {
                if (N.getSdt().equals(phone.getText())) {
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
            for (NhanVien N : QLNV.CodeGym) {
                if (N.getEmail().toLowerCase(Locale.ROOT).equals(email.getText().toLowerCase(Locale.ROOT))) {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getInfo(new ActionEvent());
    }

    @FXML
    public void switchToEditSearch(ActionEvent event) throws Exception {
        m.changeScene("/Package/FXML/EditScreenSearch.fxml");
    }
}
