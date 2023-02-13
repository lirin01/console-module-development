import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {
    String text;
    boolean switcher;

    public int choice(Scanner scanString, View view) {
        switcher=true;
        int sent;
        while (switcher) {
            view.message(1);
            text = scanString.nextLine();
            view.line();
            if ((Pattern.matches("[0-8]{1}", text))) {
                switcher = false;
            } else {
                view.errorCondition(14);
                view.line();
            }
        }
        sent=Integer.parseInt(text);
        return sent;
    }
    public String validateContactNumber(Scanner scanString, View view,int choice,int choice2) {
        switcher=true;
        while (switcher) {
            text = scanString.nextLine();
            if ((Pattern.matches("[0-9]{10}", text))) {
                switcher = false;
            } else {
                view.errorCondition(choice2);
                view.contactNumberMessage(choice);
            }
        }
        return text;
    }
    public String validateDesignation(Scanner scanString, View view,int choice,int choice2) {
        switcher=true;
        while (switcher) {
            text = scanString.nextLine();
            if ((Pattern.matches("[a-zA-z]{1,15}", text))) {
                switcher = false;
            } else {
                view.errorCondition(choice2);
                view.designationMessage(choice);
            }
        }
        return text;
    }
    public String validateFirstName(Scanner scanString, View view,int choice,int choice2) {
        switcher=true;
        while (switcher) {
            text = scanString.nextLine();
            if ((Pattern.matches("[a-zA-z]{2,15}", text))) {
                switcher = false;
            } else {
                view.errorCondition(choice2);
                view.firstNameMessage(choice);
            }
        }
        return text;
    }
    public String validateSecondName(Scanner scanString, View view,int choice,int choice2) {
        switcher=true;
        while (switcher) {
            text = scanString.nextLine();
            if ((Pattern.matches("[a-zA-z]{1,15}", text))) {
                switcher = false;
            } else {
                view.errorCondition(choice2);
                view.secondNameMessage(choice);
            }
        }
        return text;
    }
    public JSONObject validateDataFile(JSONParser jsonParser,String DATA_PATH,JSONObject database){
        int temp=0;
        int max=0;
        try{
            database = (JSONObject) jsonParser.parse(new FileReader(DATA_PATH));
            temp=1;
        }
        catch(Exception e){
            JSONObject set_employee_id = new JSONObject();
            set_employee_id.put("employee id", 1);
            database = set_employee_id;
        }

        if(temp==1){
            if(database.get("employee id")==null){
                for (Object individual_key : database.keySet()) {
                    max=(Integer.parseInt((String)individual_key));
                }
                database.put("employee id",max+1);
            }
        }
        return database;
    }
    public JSONObject validateAuthenticationFile(JSONObject authentication_database,JSONParser jsonParser,String AUTHENTICATION_DATA_PATH){
        try{
            authentication_database = (JSONObject) jsonParser.parse(new FileReader(AUTHENTICATION_DATA_PATH));
        }
        catch(Exception e){
            JSONObject initializer=new JSONObject();
            JSONObject admin=new JSONObject();
            JSONObject employee=new JSONObject();
            admin.put("a","a");
            initializer.put("admin",admin);
            initializer.put("employee",employee);
            authentication_database=initializer;
        }
        return authentication_database;
    }
    public JSONObject validateDeletedFile(JSONObject deleted_database,JSONParser jsonParser,String DELETED_DATA_PATH){
        try{
            deleted_database=(JSONObject) jsonParser.parse(new FileReader(DELETED_DATA_PATH));
        }
        catch(Exception e){
            JSONObject initializer=new JSONObject();
            deleted_database= initializer;
        }
        return deleted_database;
    }
}
// 321801505680
// icic0007384