package Package.Classes;

public class NhanVienDaoTaoFullTime extends NhanVienDaoTao{
    public NhanVienDaoTaoFullTime(String name, String age, String gender, String sdt, String email, long salary) {
        super(name, age, gender, sdt, email, salary);
    }

    @Override
    public long getTotalSalary() {
        return getSalary()*8;
    }
    @Override
    public String toString() {
        return "Nhan Vien Dao Tao Full Time{" +
                "ten: " + getName() +
                ", tuoi: " + getAge() +
                ", gioi tinh: " + getGender() +
                ", sdt: " + getSdt() +
                ", email: " + getEmail() +
                ", luong: " + getSalary() +
                ", tong luong: " + getTotalSalary() +
                ", tinh trang: " + getStatus() +
                '}';
    }
}
