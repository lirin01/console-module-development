import org.json.simple.JSONObject;

public class AdminEditDetails {
    EditProcess editProcess=new EditProcess();
    AdminEditDetailsById adminEditDetailsById=new AdminEditDetailsById();
    AdminEditDetailsByName adminEditDetailsByName=new AdminEditDetailsByName();
    public void edit(JSONObject database,View view,GetDetails getDetails,Validator validator) {
        if (database.size() == 1) { //checking database is empty or not
            view.errorCondition(1);
        } else {
            int choice=getDetails.searchOptions(validator); // inside else
            switch (choice) {
                case 1: //edit by employee id
                {
                    adminEditDetailsById.edit(database,view,getDetails,editProcess,validator);
                    break;
                }
                case 2: //edit by name
                {
                    adminEditDetailsByName.edit(database,view,getDetails,editProcess,validator);
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
