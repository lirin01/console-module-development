import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class AdminLogin {
    public void login(JSONObject authentication_database,GetDetails getDetails,Controller controller,JSONObject database,JSONObject deleted_database,View view,Validator validator) throws ParseException, IOException {
        JSONObject admin_authentication_database=(JSONObject) authentication_database.get("admin");
        String user_name= getDetails.getAuthenticationDetails(1);
        String password= getDetails.getAuthenticationDetails(2);
            if(admin_authentication_database.get(user_name).equals(password)) {
                controller.adminAccount(database, deleted_database,authentication_database,getDetails,view,validator);
            }
            else{
                view.line();
                view.errorCondition(7);
                view.line();
            }
        }
    }
