package Package.Classes;

public class NhanVienDaoTaoPartTime extends NhanVienDaoTao{
    public long hourWorked;

    public NhanVienDaoTaoPartTime(String name, String age, String gender, String sdt, String email, long salary, long hourWorked) {
        super(name, age, gender, sdt, email, salary);
        this.hourWorked = hourWorked;
    }

    public long getHourWorked() {
        return hourWorked;
    }

    public void setHourWorked(int hourWorked) {
        this.hourWorked = hourWorked;
    }

    @Override
    public long getTotalSalary() {
        return getSalary()*getHourWorked();
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
                ", so gio lam: " + getHourWorked() +
                ", tong luong: " + getTotalSalary() +
                ", tinh trang: " + getStatus() +
                '}';
    }
}
