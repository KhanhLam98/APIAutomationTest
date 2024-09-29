package BaiTap7_CollectionArrayList;

import java.util.ArrayList;

public class NhanVien {
    public static void main(String[] args) {
        ArrayList<String> nhanVien = new ArrayList<>();
        //Luu thong tin nhan vien vao Array List
        nhanVien.add("Ho ten: Nguyen Ngoc Khanh Lam");
        nhanVien.add("Tuoi: 26");
        nhanVien.add("Vi tri: Manual Tester");

        //In ra thong tin
        for (String info : nhanVien) {
            System.out.println(info);
        }
    }
}
