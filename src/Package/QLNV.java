package Package;

import Package.Classes.*;

import java.util.ArrayList;
import java.util.Scanner;

public class QLNV {
    public static ArrayList<NhanVien> CodeGym = IOOperator.readDataFromFile("E:\\firstFX\\src\\Package\\list.txt");

    public static void sortByName() {
        NameSorter nameSorter = new NameSorter();
        CodeGym.sort(nameSorter);
    }
}
