import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Controller {
    int choice;
    RemoveDetails removeDetails=new RemoveDetails();
    AdminEditDetails adminEditDetails=new AdminEditDetails();
    ShowIndividualDetails showIndividualDetails=new ShowIndividualDetails();
    AddDetails addDetails=new AddDetails();
    public void adminAccount(JSONObject database,JSONObject deleted_database,JSONObject authentication_database,GetDetails getDetails,View view,Validator validator) throws ParseException, IOException{
        view.line();
            view.successMessage(6);
            choice=0;
            while (choice != 8) {
                view.mainOptions(1);
                choice=getDetails.choice(validator);
                switch (choice) {
                    case 1: //add new employee
                    {
                        addDetails.addNewEmployee(database,(JSONObject) authentication_database.get("employee"),view,getDetails);
                        break;
                    }
                    case 2: //view individual employee
                    {
                        showIndividualDetails.show(database,view,getDetails,validator);
                        break;
                    }
                    case 3: //edit or update employee
                    {
                        adminEditDetails.edit(database,view,getDetails,validator);
                        break;
                    }
                    case 4: //view all employee details
                    {
                        view.viewAll(database);
                        break;
                    }
                    case 5: //remove employee details
                    {
                        removeDetails.remove(database,deleted_database,view,getDetails,authentication_database,validator);
                        break;
                    }
                    case 6: //view deleted details
                    {
                        view.deletedDetails(deleted_database);
                        break;
                    }
                    case 7://add new admin credentials
                    {
                        addDetails.addNewAdmin(getDetails,authentication_database);
                        break;
                    }
                    case 8: //exit
                    {
                        break;
                    }
                    default:
                    {
                        view.invalidCommand();
                        break;
                    }
                }
            }
        }
    public void employeeAccount(JSONObject database,JSONObject authentication,GetDetails getDetails,View view,Validator validator){
        EmployeeEditDetails employeeEditDetails=new EmployeeEditDetails();
        view.line();
        view.successMessage(7);
        choice=0;
        while (choice != 8) {
            view.mainOptions(2);
            choice=getDetails.choice(validator);
            switch (choice) {
                case 1: //view
                {
                    try{
                        view.individualView(database);
                    }
                    catch (Exception e){
                        view.errorCondition(5);
                    }
                    break;
                }
                case 2:
                { //edit
                    try{
                        employeeEditDetails.edit(database,validator);
                    }
                    catch (Exception e){
                        view.errorCondition(5);
                    }
                   break;
                }
                case 3: // change password
                {
                    authentication.replace("password",getDetails.getAuthenticationDetails(3));
                    view.successMessage(8);
                }
                case 4:
                {
                    break;
                }
                default: {
                    view.invalidCommand();
                    break;
                }
            }
        }
    }
}
