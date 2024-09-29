package BaiTap1_Bien;

public class SinhVien {
    static String diaChi = "Ly Tu Trong, NK, CT";
    int tuoi = 26;

    public static void main(String[] args) {
        String ten = "Nguyen Ngoc Khanh Lam";
        SinhVien sv = new SinhVien();
        System.out.println("Ho ten: " +ten);
        System.out.println("Dia chi: " +diaChi);
        System.out.println("Tuoi: " +sv.tuoi);
        System.out.println("Lop: " +ThongTin.tenLop);
    }
}
