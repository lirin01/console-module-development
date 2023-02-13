import org.json.simple.JSONObject;

public class ShowIndividualDetails {
    public void show(JSONObject database,View view,GetDetails getDetails,Validator validator) {
        if (database.size() == 1) {
            System.out.println("check1");
            view.errorCondition(1);
        }
        else {
            view.searchOption(1);
            switch (getDetails.choice(validator)) {
                case 1: //view individual data by employee id
                {
                    try {//try catch for data not found condition
                        view.individualView((JSONObject) database.get(String.valueOf(getDetails.getEmployeeId())));
                    } catch (Exception e) {
                        view.errorCondition(5);
                    }
                    break;
                }
                case 2: //view individual data by name
                {
                    String first_name=getDetails.getFirstName(1);
                    String second_name=getDetails.getSecondName(1);
                    int flag=0;
                    for (Object individual_key:database.keySet()) {
                        if(individual_key.equals("employee id"));
                        else{
                            JSONObject individual_data = (JSONObject) database.get(individual_key);
                            if (individual_data.get("First name").equals(first_name) && individual_data.get("Second name").equals(second_name)) {
                                view.individualView(individual_data);
                                flag=1;
                            }
                        }
                    }
                    if(flag==0){
                        view.errorCondition(5);
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
