package BaiTap6_Mang;

public class Mang {
    public static void main(String[] args) {
        int mang[] = new int[26];
        int a = 0;
        //Tao vong lap for de in cac so chan tu 0 -> 50
        for (int i=0; i<=50; i++) {
            if(i%2 == 0) {
            //System.out.println(i); // In so chan tu 0 -> 50
            //luu gia tri vao mang nhung so chan tren
              mang[a] = i;
              a++;
            }
        }
        //Duyet mang
        for (int temp : mang){
            System.out.println(temp);
        }
    }
}
