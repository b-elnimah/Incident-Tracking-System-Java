package incident.tracking.system.its;

import java.util.ArrayList;

/**
 *
 * @author abdallah
 */
public class UserAccount {
    private static long serialVersionUID ;
    private static String filePath ; 
    private static String userName ;
    private static String password ;
    private static ArrayList<UserAccount> users = new ArrayList<>();

    UserAccount(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public static String getPassword() {
        return password;
    }
    
    
    public boolean isUserNameTaken(String userName){
        for(UserAccount us : users){
            if(us.getUserName().equals(userName)){
                return true;
            }
        }
        return false;
    }
    public static UserAccount creatUser(String name,String password){
        UserAccount user = new UserAccount(name, password);
        users.add(user);
        return user;
    }
    
    private UserAccount getUser(String userName){
        UserAccount us = new UserAccount("a", "a");
        for(UserAccount user : users){
            if(user.userName.equals(userName)){
                us = user ;
            }
        }
        return us;
    }
    
    public static UserAccount login(){
        for(UserAccount user  : users){
            if(user.userName.equals(userName)&&user.password.equals(password))
                return user;
        }
        
        return null;
    }
    
    public UserAccount guiLogin(){
        return null;
    }
    
   
    public  UserAccount logout(){
        return null;
    }
    
    private static void saveUser(UserAccount user){
         
    }
    private ArrayList<UserAccount> loadUsers(){
        return users;
    }
    
    
}
