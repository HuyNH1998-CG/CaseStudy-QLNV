package Package.Classes;

public class NhanVienDaoTaoPartTime extends NhanVienDaoTao {

    public NhanVienDaoTaoPartTime(String name, String age, String gender, String sdt, String email, long salary, long hourWorked) {
        super(name, age, gender, sdt, email, salary, hourWorked);
    }

    @Override
    public long getTotalSalary() {
        return getSalary() * getOthers();
    }

    @Override
    public String toString() {
        return "Nhan Vien Dao Tao Part Time{" +
                "ten: " + getName() +
                ", tuoi: " + getAge() +
                ", gioi tinh: " + getGender() +
                ", sdt: " + getSdt() +
                ", email: " + getEmail() +
                ", luong: " + getSalary() +
                ", so gio lam: " + getOthers() +
                ", tong luong: " + getTotalSalary() +
                ", tinh trang: " + getStatus() +
                '}';
    }
}
