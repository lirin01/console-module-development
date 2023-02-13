import org.json.simple.JSONObject;

public class AdminEditDetailsByName {
    int choice;
    public void edit(JSONObject database,View view,GetDetails getDetails,EditProcess editProcess,Validator validator) {
        choice=0;
        while (choice != 5) {
            view.editOptions();
            choice= getDetails.choice(validator);
            switch (choice) {
                case 1: //update first name by name
                {
                    choice=editProcess.edit(getDetails,view,database,choice,3);
                    break;
                }
                case 2: //update second name by name
                {
                    choice= editProcess.edit(getDetails,view,database,choice,4);
                    break;
                }
                case 3: // update contact number by name
                {
                    choice= editProcess.edit(getDetails,view,database,choice,5);
                    break;
                }
                case 4: //update designation by name
                {
                    choice=editProcess.edit(getDetails,view,database,choice,6);
                    break;
                }
                case 5: //update designation by name
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
