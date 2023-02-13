import org.json.simple.JSONObject;

public class View {

    public void line() {
        System.out.println("------------------------------------------------------------------------");
    }
    public void mainOptions(int choice){
        switch (choice)
        {
            case 1:
            {
                line();
                System.out.println("Enter 1 to add employee");
                System.out.println("Enter 2 to view employee details");
                System.out.println("Enter 3 to update or edit");
                System.out.println("Enter 4 to view all employee details");
                System.out.println("Enter 5 to remove employee details");
                System.out.println("Enter 6 to view deleted employee details");
                System.out.println("Enter 7 to add new admin");
                System.out.println("Enter 8 to exit");
                line();
                break;
            }
            case 2:
            {
                line();
                System.out.println("Enter 1 to view your details");
                System.out.println("Enter 2 to edit details");
                System.out.println("Enter 3 to change password");
                System.out.println("Enter 4 to logout");
                line();
                break;
            }
        }
    }
    public void editOptions(){
        System.out.println("Enter 1 to edit first name");
        System.out.println("Enter 2 to edit second name");
        System.out.println("Enter 3 to edit contact number");
        System.out.println("Enter 4 to edit designation");
        System.out.println("Enter 5 to exit");
        line();
    }

    public void individualView(JSONObject individual_details) {
        line();
        String[] array={"Employee id","First name","Second name","Contact number","Designation","Jointed time","Jointed date"};
        for(String i:array){
            System.out.println(i +" : " + individual_details.get(i));
        }
    }

    public void tableView(JSONObject database) {
        String format = ("|%20s    |%20s    |%20s    |%18s    |%20s    |%15s    |%15s    |%n");
        System.out.println("____________________________________________________________________________________________________________________________________________________________________");
        System.out.format(format, "Employee id", "First name", "Second name", "Contact number", "Designation", "Jointed time", "Jointed date");
        System.out.println("____________________________________________________________________________________________________________________________________________________________________");
        for (Object individual_key : database.keySet()) {
            if (individual_key.equals("employee id")) ;
            else {
                JSONObject individual_obj = (JSONObject) database.get(individual_key);
                System.out.format(format, individual_obj.get("Employee id"), individual_obj.get("First name"), individual_obj.get("Second name"), individual_obj.get("Contact number"), individual_obj.get("Designation"), individual_obj.get("Jointed time"), individual_obj.get("Jointed date"));
                System.out.println("____________________________________________________________________________________________________________________________________________________________________");
            }
        }
    }

    public void viewAll(JSONObject database) {
        if (database.size() == 1) { //checking database is empty or not
            System.out.println("!..... no data found in the database .....!");
        } else {
            tableView(database);
        }
    }

    public void deletedDetails(JSONObject deleted_database)  {
        if (deleted_database.size() == 0) { //checking database is empty or not
            errorCondition(6);
        } else {
            tableView(deleted_database);
        }
    }
    public void errorCondition(int choice){
        switch (choice){
            case 1:
            {
                System.out.println("#***** No data found in the database *****#");
                break;
            }
            case 2:
            {
                System.out.println("#***** No data found in this ID *****#");
                break;
            }
            case 3:
            {
                System.out.println("!..... Given name not found in the database .....!");
                break;
            }
            case 4:
            {
                System.out.println("#***** No data found in the database to remove *****#");
                break;
            }
            case 5:
            {
                System.out.println("<***** Data not found,try again.! *****>");
                break;
            }
            case 6:
            {
                System.out.println("!..... no data found in the deleted database .....!");
                break;
            }
            case 7:
            {
                System.out.println("Given password does not matched");
                break;
            }
            case 8:
            {
                System.out.println("Given username or password does not matched");
                break;
            }
            case 9:{
                System.out.println("Error occurs");
                break;
            }
            case 10:{
                System.out.println("Entered contact number is not valid , Enter correctly");
                break;
            }
            case 11:{
                System.out.println("Entered first name is not valid , Enter correctly");
                break;
            }
            case 12:{
                System.out.println("Entered second name is not valid , Enter correctly");
                break;
            }
            case 13:{
                System.out.println("Entered designation is not valid , Enter correctly");
                break;
            }
            case 14:
            {
                System.out.println("Entered choice is not valid , Enter correctly");
                break;
            }
        }
    }
    public void invalidCommand(){
        System.out.println("<<<<< Entered invalid command >>>>>");
    }
    public void successMessage(int choice){

        switch (choice)
        {
            case 1:
            {
                System.out.println("First name updated successfully");
                break;
            }
            case 2:
            {
                System.out.println("Second name updated successfully");
                break;
            }
            case 3:
            {
                System.out.println("Contact number updated successfully");
                break;
            }
            case 4:
            {
                System.out.println("Designation updated successfully");
                break;
            }
            case 5:
            {
                System.out.println("employee data removed successfully");
                break;
            }
            case 6:
            {
                System.out.println("Successfully logged in as admin");
                break;
            }
            case 7:
            {
                System.out.println("Successfully logged in as employee");
                 break;
            }
            case 8:
            {
                System.out.println("Password changed successfully");
                break;
            }
        }
    }
    public void searchOption(int choice){
        switch(choice){
            case 1:
            {
                System.out.println("Enter 1 to search by ID");
                System.out.println("Enter 2 to search by Name");
                line();
                break;
            }
            case 2:
            {
                System.out.println("Enter 1 to edit by ID");
                System.out.println("Enter 2 to edit by Name");
                line();
            }
        }
    }
    public void authenticationOption(){
        System.out.println("Enter 1 to admin login");
        System.out.println("Enter 2 to employee login");
        System.out.println("Enter 3 to shut the program");

        line();
    }

    public void firstNameMessage(int choice){
        switch (choice)
        {
            case 1:
            {
                System.out.print("Enter the employee first name : ");
                break;
            }
            case 2:
            {
                System.out.print("Enter the new first name you want to change : ");
                break;
            }
            case 3:
            {
                System.out.print("Enter your old first name to change : ");
                break;
            }
            case 4:
            {
                System.out.print("Enter your first name to change your second name : ");
                break;
            }
            case 5:
            {
                System.out.print("Enter your first name to change your contact number : ");
                break;
            }
            case 6:
            {
                System.out.print("Enter your first name to change your designation : ");
                break;
            }
        }
    }

    public void secondNameMessage(int choice){
        switch (choice)
        {
            case 1:
            {
                System.out.print("Enter the employee Second name : ");
                break;
            }
            case 2:
            {
                System.out.print("Enter the new second name you want to change : ");
                break;
            }
            case 3:
            {
                System.out.print("Enter your second name to change the first name : ");
                break;
            }
            case 4:
            {
                System.out.print("Enter your old second name to change  : ");
                break;
            }
            case 5:
            {
                System.out.print("Enter your second name to change your contact number : ");
                break;
            }
            case 6:
            {
                System.out.print("Enter your second name to change your designation : ");
                break;
            }
        }
    }
    public void contactNumberMessage(int choice){
        switch (choice){
            case 1:
            {
                System.out.print("Enter your contact number : ");
                break;
            }
            case 2:
            {
                System.out.print("Enter your new contact number to change : ");
                break;
            }
        }
    }

    public void designationMessage(int choice){
        switch(choice){
            case 1:
            {
                System.out.print("Enter the designation of the employee : ");
                break;

            }
            case 2:
            {
                System.out.print("Enter your new designation to change : ");
                break;
            }
        }
    }
    public void message(int choice){
        switch(choice){
            case 1:
            {
                System.out.print("Enter your choice : ");
                break;

            }
        }
    }
}

