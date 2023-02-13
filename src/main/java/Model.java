import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileWriter;
import java.io.IOException;

public class Model { //singleton class
    private static Model singleton=null;
    private Model(){
    }
    public static Model get(){
        if(singleton==null){
            singleton=new Model();
        }
        return singleton;
    }
    private String DATA_PATH="src/main/java/Data.json";
    private String DELETED_DATA_PATH="src/main/java/Deleted_data.json";
    private String AUTHENTICATION_DATA_PATH="src/main/java/Authentication.json";
    JSONParser jsonParser = new JSONParser();
    Validator validate=new Validator();

    private JSONObject database; //encapsulation
    private JSONObject deleted_database; //encapsulation
    private JSONObject authentication_database; //encapsulation

    public void load() {
        database=validate.validateDataFile(jsonParser,DATA_PATH,database);
        authentication_database=validate.validateAuthenticationFile(authentication_database,jsonParser,AUTHENTICATION_DATA_PATH);
        deleted_database=validate.validateDeletedFile(deleted_database,jsonParser,DELETED_DATA_PATH);
    }
    public JSONObject getDatabase(){
        return database;
    }
    public JSONObject getDeletedDatabase(){return deleted_database;}
    public JSONObject getAuthenticationDatabase(){return authentication_database;}
    public void setDatabase(JSONObject database){
        this.database=database;
    }
    public void write(JSONObject database,JSONObject deleted_database,JSONObject authentication_database) throws IOException {
        FileWriter dataFile = new FileWriter(DATA_PATH);
        FileWriter deletedFile = new FileWriter(DELETED_DATA_PATH);
        FileWriter authenticationFile = new FileWriter(AUTHENTICATION_DATA_PATH);

        dataFile.write(database.toJSONString());
        deletedFile.write(deleted_database.toJSONString());
        authenticationFile.write(authentication_database.toJSONString());

        dataFile.close();
        deletedFile.close();
        authenticationFile.close();
    }
}
