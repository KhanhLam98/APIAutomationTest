package model.dataBuilder;

import globals.ConfigGlobal;
import model.pojo.LoginPoJo_Lombok;

public class LoginBuilder {
    public static LoginPoJo_Lombok getDataLogin(){
        return LoginPoJo_Lombok.builder()
                .username(ConfigGlobal.username)
                .password(ConfigGlobal.password)
                .build();
    }
}
