import java.util.Scanner;

public class GetDetails {
    View view=new View();
    Validator validate=new Validator();
    Scanner scanInt=new Scanner(System.in);
    Scanner scanString=new Scanner(System.in);

    public int choice(Validator validator){
        return validator.choice(scanString,view);
    }
    public int searchOptions(Validator validator){
        view.searchOption(2);
        return choice(validator);
    }
    public String getFirstName(int choice){
        view.firstNameMessage(choice);
        return validate.validateFirstName(scanString,view,choice,11);
    }
    public String getSecondName(int choice){
        view.secondNameMessage(choice);
        return validate.validateSecondName(scanString,view,choice,12);
    }
    public String getContactNumber(int choice) {
        view.contactNumberMessage(choice);
        return validate.validateContactNumber(scanString,view,choice,10);
    }
    public String getDesignation(int choice){
        view.designationMessage(choice);
        return validate.validateDesignation(scanString,view,choice,13);
    }
    public int getEmployeeId(){
        System.out.print("Enter employee id : ");
        return scanInt.nextInt();
    }
    public int saveDeletedFileOption(Validator validator){
        System.out.println("Enter 1 to save deleted file");
        System.out.println("Enter 2 to not save the deleted file");
        view.line();
        return choice(validator);
    }
    public String getCredentials() {
        System.out.print("Enter the temporary password : ");
        return scanString.nextLine();
    }
    public String getAuthenticationDetails(int choice){
        switch (choice){
            case 1:
            {
                System.out.print("Enter your username : ");
                break;
            }
            case 2:
            {
                System.out.print("Enter your password : ");
                break;
            }
            case 3:
            {
                System.out.print("Enter your new password : ");
                break;
            }
            case 4:
            {
                System.out.print("Enter new admin username : ");
                break;
            }
            case 5:
            {
                System.out.print("Enter the password : ");
                break;
            }
        }
        return scanString.nextLine();
    }
}

