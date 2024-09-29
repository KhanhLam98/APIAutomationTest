package BaiTap3_ToanTu;

public class ToanTu {
    static int a = 10;
    static int b = 40;
    static int c = 20;

    public static void main(String[] args) {
        System.out.println("Phep cong: " +(a+b));
        System.out.println("Phep chia lay phan du: " +(a % c));
        System.out.println("So sanh &&: " +(a > b && a == c));
        System.out.println("So sanh ||: " +(a < b || a > c));
    }
}
