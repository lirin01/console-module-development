import org.json.simple.JSONObject;

public class EmployeeLogin {
    public void login(JSONObject authentication_database,GetDetails getDetails,Controller controller,JSONObject database,View view,Validator validator)  {
            JSONObject employee_authentication_database=(JSONObject) authentication_database.get("employee");
            String user_name= getDetails.getAuthenticationDetails(1);
            String password= getDetails.getAuthenticationDetails(2);
            if(((JSONObject)employee_authentication_database.get(user_name)).get("password").equals(password)) {
                JSONObject individual_data=(JSONObject) employee_authentication_database.get(user_name);
                controller.employeeAccount((JSONObject) database.get(individual_data.get("Employee id")),(JSONObject) employee_authentication_database.get(user_name),getDetails,view,validator);
            }
            else{
                view.line();
                view.errorCondition(7);
                view.line();
            }
        }
    }
