package Package;

import Package.Classes.NhanVien;

import java.util.Comparator;


public class NameSorter implements Comparator<NhanVien> {

    @Override
    public int compare(NhanVien o1, NhanVien o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
