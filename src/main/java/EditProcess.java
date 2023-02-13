import org.json.simple.JSONObject;


public class EditProcess {
    // overloading
    public void edit(JSONObject individual_obj, JSONObject database, String emp_id, int choice, String option, String dataToChange, View view) { // for admin
        individual_obj.replace(option, dataToChange);
        database.replace(emp_id, individual_obj);
        view.successMessage(choice);
    }

    public void edit(JSONObject database, String option, String firstName, int choice, View view) { //for employee
        database.replace(option, firstName);
        view.successMessage(choice);
        view.line();
    }

    public int edit(GetDetails getDetails, View view, JSONObject database, int choice,int name_choice) {
        String first_name = getDetails.getFirstName(name_choice);
        String second_name = getDetails.getSecondName(name_choice);
        int flag = 0;
        view.line();
        for (Object individual_key : database.keySet()) {
            if (individual_key.equals("employee id")) ;
            else {
                JSONObject individual_obj = (JSONObject) database.get(individual_key);
                if (individual_obj.get("First name").equals(first_name) && individual_obj.get("Second name").equals(second_name)) {
                    flag = 1;
                    switch (choice){
                        case 1:{
                            edit(individual_obj, database, String.valueOf(individual_key),1, "First name", getDetails.getFirstName(2), view);
                            break;
                        }
                        case 2:
                        {
                            edit(individual_obj,database,String.valueOf(individual_key),2,"Second name",getDetails.getSecondName(2),view);
                            break;
                        }
                        case 3:
                        {
                            edit(individual_obj,database,String.valueOf(individual_key),3,"Contact number",String.valueOf(getDetails.getContactNumber(2)),view);
                            break;
                        }
                        case 4:
                        {
                            edit(individual_obj,database,String.valueOf(individual_key),4,"Designation",getDetails.getDesignation(2),view);
                            break;
                        }
                    }
                    view.line();
                }
            }
        }
        if (flag == 0) {
            view.errorCondition(3);
            choice = 5;
        }
        return choice;
    }
}

