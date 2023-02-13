import org.json.simple.JSONObject;

public class RemoveDetails {
    int choice;
    public void remove(JSONObject database,JSONObject deleted_database,View view,GetDetails getDetails,JSONObject authentication_database,Validator validator)  {
        if (database.size() == 1) {
            view.errorCondition(4);
        }
        else {
            view.searchOption(1);
            switch (getDetails.choice(validator)) {
                case 1: //remove employee data by employee id
                {
                    int emp_id;
                    emp_id = getDetails.getEmployeeId();
                    view.line();
                    choice=getDetails.saveDeletedFileOption(validator);
                    if(choice==1){
                        deleted_database.put(emp_id,database.get(String.valueOf(emp_id)));
                    }
                    ((JSONObject) authentication_database.get("employee")).remove(((JSONObject) database.get(String.valueOf(emp_id))).get("First name")+"."+((JSONObject) database.get(String.valueOf(emp_id))).get("Second name")+((JSONObject) database.get(String.valueOf(emp_id))).get("Employee id"));
                    database.remove(String.valueOf(emp_id));
                    view.successMessage(5);
                    break;
                }
                case 2: //remove employee data by name
                {
                    String first_name=getDetails.getFirstName(1);
                    String second_name=getDetails.getSecondName(1);
                    int flag=0;
                    view.line();
                    for (Object individual_key:database.keySet()) {
                        if(individual_key.equals("employee id"));
                        else{
                            JSONObject individual_obj = (JSONObject) database.get(individual_key);
                            if (individual_obj.get("First name").equals(first_name) && individual_obj.get("Second name").equals(second_name)) {
                                System.out.println(individual_obj);
                                flag=1;
                                choice=getDetails.saveDeletedFileOption(validator);
                                if(choice==1) {
                                    deleted_database.put(String.valueOf(individual_obj.get("Employee id")),individual_obj);
                                }
                                ((JSONObject) authentication_database.get("employee")).remove((individual_obj.get("First name")+"."+individual_obj.get("Second name")+individual_obj.get("Employee id")));
                                database.remove(String.valueOf(individual_obj.get("Employee id")));
                                view.successMessage(5);
                                break;
                            }
                        }
                    }
                    if(flag==0){
                        view.errorCondition(3);
                    }
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
