import org.json.simple.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddDetails {
    long employee_Id;
    public void addNewEmployee(JSONObject database, JSONObject authentication_database, View view, GetDetails getDetails)  {
        try{
            employee_Id= (long) database.get("employee id");
        }
        catch(Exception e){
            employee_Id=(Integer) database.get("employee id");
        }
        JSONObject jsonObject = new JSONObject();
        JSONObject credentials=new JSONObject();
        jsonObject.put("First name",getDetails.getFirstName(1));//.getFirstName(1))
        jsonObject.put("Second name", getDetails.getSecondName(1));
        jsonObject.put("Contact number", getDetails.getContactNumber(1));
        jsonObject.put("Designation",getDetails.getDesignation(1));
        jsonObject.put("Employee id", employee_Id);
        jsonObject.put("Jointed time", LocalDateTime.now().toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        jsonObject.put("Jointed date", LocalDateTime.now().toLocalDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        database.put(String.valueOf(employee_Id), jsonObject);
        credentials.put("password",getDetails.getCredentials());
        credentials.put("Employee id",String.valueOf(employee_Id));
        authentication_database.put((jsonObject.get("First name")+"."+jsonObject.get("Second name")+jsonObject.get("Employee id")),credentials);
        database.replace("employee id", employee_Id + 1);
        System.out.println("Employee data added successfully , your employee id is :" +employee_Id);
        view.line();
        System.out.println("your username is : "+(jsonObject.get("First name")+"."+jsonObject.get("Second name")+jsonObject.get("Employee id")));
        System.out.println("your temporary password is : "+credentials.get("password"));
    }
    public void addNewAdmin(GetDetails getDetails,JSONObject authentication_database ){
        String name=getDetails.getAuthenticationDetails(4);
        String password= getDetails.getAuthenticationDetails(5);
        ((JSONObject)(authentication_database.get("admin"))).put(name,password);
    }
}
