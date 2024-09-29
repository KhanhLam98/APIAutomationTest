package BaiTap7_CollectionArrayList;

import java.util.ArrayList;

public class BaiTapArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        //Tao vong lap for de in cac so chan tu 0 -> 50
        for (int i=0; i<=50; i++) {
            if(i%2 == 0) {
                //System.out.println(i); // In so chan tu 0 -> 50
                //luu gia tri vao mang nhung so chan tren
                arrayList.add(i);
            }
        }
        //Duyet mang
        for (int temp : arrayList){
            System.out.println(temp);
        }
    }
}
