package Package.Classes;

public class NhanVienTuyenSinh extends NhanVien {


    public NhanVienTuyenSinh(String name, String age, String gender, String sdt, String email, long salary, long recruitedAmount) {
        super(name, age, gender, sdt, email, salary, recruitedAmount);
    }


    @Override
    public long getTotalSalary() {
        return getSalary() * 8 + (getOthers() * 10);
    }

    @Override
    public String toString() {
        return "Nhan Vien Tuyen Sinh{" +
                "ten: " + getName() +
                ", tuoi: " + getAge() +
                ", gioi tinh: " + getGender() +
                ", sdt: " + getSdt() +
                ", email: " + getEmail() +
                ", luong: " + getSalary() +
                ", so luong hoc vien da tuyen : " + getOthers() +
                ", tong luong: " + getTotalSalary() +
                ", tinh trang: " + getStatus() +
                '}';
    }
}
