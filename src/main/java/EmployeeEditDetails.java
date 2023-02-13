import org.json.simple.JSONObject;

public class EmployeeEditDetails {
    int choice;
    EditProcess editProcess=new EditProcess();
    GetDetails getDetails=new GetDetails();
    View view=new View();
    public void edit(JSONObject database,Validator validator){
        choice=0;
        while(choice!=5){
            view.editOptions();
            choice=getDetails.choice(validator);
            switch(choice){
                case 1:
                {
                    editProcess.edit(database,"First name",getDetails.getFirstName(2),1,view);
                    break;
                }
                case 2:
                {
                    editProcess.edit(database,"Second name",getDetails.getSecondName(2),2,view);
                    break;
                }
                case 3:
                {
                    editProcess.edit(database,"Contact number",String.valueOf(getDetails.getContactNumber(2)),3,view);
                    break;
                }
                case 4:
                {
                    editProcess.edit(database,"Designation",getDetails.getDesignation(2),4,view);
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
