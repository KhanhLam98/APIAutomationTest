package globals;

import helpers.PropertiesHelper;

public class EndpointGlobal {
    public static final String login = PropertiesHelper.getValue("login");
    public static final String booking = PropertiesHelper.getValue("booking");
}
