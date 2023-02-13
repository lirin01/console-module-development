import org.json.simple.JSONObject;

import java.io.IOException;



//admin username : a
//admin password : a

public class Main{
    public static void main(String[] args) throws IOException{
        int choice;
        Model model=Model.get();
        GetDetails getDetails=new GetDetails();
        View view=new View();
        Validator validator=new Validator();
        Controller controller=new Controller();
        AdminLogin adminLogin=new AdminLogin();
        EmployeeLogin employeeLogin=new EmployeeLogin();


        model.load(); // load database from file to model

        // databases
        JSONObject database=model.getDatabase();
        JSONObject deleted_database=model.getDeletedDatabase();
        JSONObject authentication_database=model.getAuthenticationDatabase();


        try{
            choice=0;
            while(choice!=3){
                view.authenticationOption();
                choice=getDetails.choice(validator);
                switch(choice){
                    case 1:
                    {
                        adminLogin.login(authentication_database,getDetails,controller,database,deleted_database,view,validator);
                        break;
                    }
                    case 2:
                    {
                        employeeLogin.login(authentication_database,getDetails,controller,database,view,validator);
                        break;
                    }
                    case 3:{
                        model.write(database,deleted_database,authentication_database);
                        break;
                    }
                    default:
                    {
                        view.invalidCommand();
                        view.line();
                    }
                }
            }
        }
        catch(Exception e){
            model.write(database,deleted_database,authentication_database);
            view.line();
        }
    }
}