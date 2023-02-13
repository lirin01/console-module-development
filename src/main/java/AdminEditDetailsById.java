import org.json.simple.JSONObject;

public class AdminEditDetailsById {
    int choice;
    int emp_id;

    public void edit(JSONObject database,View view,GetDetails getDetails,EditProcess editProcess,Validator validator){
        emp_id = getDetails.getEmployeeId();
        choice=0;
        while (choice != 5) {
            if(database.get(String.valueOf(emp_id))==null){
                view.line();
                view.errorCondition(2);
            }
            else{
                view.line();
                view.editOptions();
                choice= getDetails.choice(validator);
                switch (choice) {
                    case 1://update first name by id
                    {
                        JSONObject individual_Details = (JSONObject) database.get(String.valueOf(emp_id));
                        editProcess.edit(individual_Details,database,String.valueOf(emp_id),1,"First name",getDetails.getFirstName(2),view);
                        break;
                    }
                    case 2://update second name by id
                    {
                        JSONObject individual_Details = (JSONObject) database.get(String.valueOf(emp_id));
                        editProcess.edit(individual_Details,database,String.valueOf(emp_id),2,"Second name",getDetails.getSecondName(2),view);
                        break;
                    }
                    case 3: //update contact number by id
                    {
                        JSONObject individual_Details = (JSONObject) database.get(String.valueOf(emp_id));
                        editProcess.edit(individual_Details,database,String.valueOf(emp_id),3,"Contact number",String.valueOf(getDetails.getContactNumber(2)),view);
                        break;
                    }
                    case 4: //update designation by id
                    {
                        JSONObject individual_Details = (JSONObject) database.get(String.valueOf(emp_id));
                        editProcess.edit(individual_Details,database,String.valueOf(emp_id),4,"Designation",getDetails.getDesignation(2),view);
                        break;
                    }
                    case 5:
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
    }
}
