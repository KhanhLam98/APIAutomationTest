package globals;

import helpers.PropertiesHelper;

public class ConfigGlobal {
    public static String baseUri = PropertiesHelper.getValue("baseUri");
    public static String username = PropertiesHelper.getValue("username");
    public static String password = PropertiesHelper.getValue("password");
    public static String contentType = PropertiesHelper.getValue("contentType");
    public static String accept = PropertiesHelper.getValue("accept");
}
