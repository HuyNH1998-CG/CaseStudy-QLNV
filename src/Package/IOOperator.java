package Package;

import Package.Classes.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOOperator {
    public static void writeToFile(String path, List<NhanVien> employee) {
        try {
            FileOutputStream fos = new FileOutputStream(path, false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(employee);
            oos.close();
        } catch (IOException e) {
            System.out.println("An Error Has Occur");
        }
    }

    public static void writeAdmin(String path, List<Admin> admins) {
        try {
            FileOutputStream fos = new FileOutputStream(path, false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(admins);
            oos.close();
        } catch (IOException e) {
            System.out.println("An Error Has Occur");
        }
    }

    public static void getLoggedUser(String path, Admin admins) {
        try {
            FileOutputStream fos = new FileOutputStream(path, false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(admins);
            oos.close();
        } catch (IOException e) {
            System.out.println("An Error Has Occur");
        }
    }public static Admin readLoggedUser(String path) {
        Admin admin = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            admin = (Admin) ois.readObject();
            ois.close();
        } catch (Exception ex) {
            System.out.println("An Error Has Occur");
        }
        return admin;
    }

    public static ArrayList<NhanVien> readDataFromFile(String path) {
        ArrayList<NhanVien> nhanVien = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            nhanVien = (ArrayList<NhanVien>) ois.readObject();
            ois.close();
        } catch (Exception ex) {
            System.out.println("An Error Has Occur");
        }
        return nhanVien;
    }

    public static ArrayList<Admin> readAdminUser(String path) {
        ArrayList<Admin> admins = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            admins = (ArrayList<Admin>) ois.readObject();
            ois.close();
        } catch (Exception ex) {
            System.out.println("An Error Has Occur");
        }
        return admins;
    }
}
