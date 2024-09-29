package baitapjava_oop3.testcases;

import baitapjava_oop3.common.BaseTest;

public class TestCases extends BaseTest {
    //Test case 1
    public void Login() {
        System.out.println("*** Test case Login ***");
        createDriver();
        System.out.println("Truyen vao gia tri username chinh xac");
        System.out.println("Truyen vao gia tri password chinh xac");
        System.out.println("Nhan vao nut Login");
        closeDriver();
        System.out.println(" ");
    }

    //Test case 2
    public void AddCategory(){
        System.out.println(" ");
        System.out.println("*** Test case Add Category ***");
        createDriver();
        System.out.println("Nhan vao nut Add Category");
        System.out.println("Truyen gia tri vao cac truong thong tin bat buoc");
        System.out.println("Nhan vao nut Save");
        closeDriver();
    }

    public static void main(String[] args) {
        TestCases testcases = new TestCases();
        testcases.Login();
        testcases.AddCategory();
    }
}
