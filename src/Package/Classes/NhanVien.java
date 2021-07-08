package Package.Classes;

import java.io.Serial;
import java.io.Serializable;

public class NhanVien implements Serializable {
    @Serial
    private static final long serialVersionUID = 123456L;
    private String name;
    private String age;
    private String gender;
    private String sdt;
    private String email;
    private long salary;
    private boolean status = false;
    private long totalSalary;
    private long others;

    public NhanVien(String name, String age, String gender, String sdt, String email, long salary) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.sdt = sdt;
        this.email = email;
        this.salary = salary;
    }

    public NhanVien(String name, String age, String gender, String sdt, String email, long salary, long others) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.sdt = sdt;
        this.email = email;
        this.salary = salary;
        this.others = others;
    }

    public String getName() {
        return ""+name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public long getTotalSalary() {
        return totalSalary;
    }

    public String getStatus() {
        if(status){
            return "Working";
        } else {
            return "Rest";
        }
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setTotalSalary(long totalSalary) {
        this.totalSalary = totalSalary;
    }

    public long getOthers() {
        return others;
    }

    public void setOthers(long others) {
        this.others = others;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "name=" + name +
                ", age=" + age +
                ", gender=" + gender +
                ", sdt=" + sdt +
                ", email=" + email +
                ", salary=" + salary +
                ", totalSalary=" + totalSalary +
                ", " + getStatus() +
                '}';
    }
}
