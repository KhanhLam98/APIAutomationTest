package model.dataBuilder;

import helpers.PropertiesHelper;
import model.pojo.Login_Anhtester;

public class LoginBuilder_AnhTester {
    public static Login_Anhtester getDataLogin(){
        PropertiesHelper.setFile("src/test/resources/demo_anhtester.properties");
//        System.out.println(PropertiesHelper.getValue("USERNAME"));
//        System.out.println(PropertiesHelper.getValue("PASSWORD"));
        return Login_Anhtester.builder()
                .username(PropertiesHelper.getValue("USERNAME"))
                .password(PropertiesHelper.getValue("PASSWORD"))
                .build();
    }
}
