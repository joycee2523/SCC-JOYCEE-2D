
package javaappjoyce;

public class Accounts {
    String firstname, lastname, email, username, password;
        int ID;
    
    public void addInfo(String fname, String lname, String umail, String uname, String pass, int UID){
        
        this.firstname=fname;
        this.lastname=lname;
        this.email=umail;
        this.username=uname;
        this.password=pass;
        this.ID= UID;
       
    }
    
    public void viewInfo(){
        
        System.out.println("-----------------------------------");
        System.out.println("ID: "+this.ID);
        System.out.println("Firstname: "+this.firstname);
        System.out.println("Lastname: "+this.lastname);
        System.out.println("Email: "+this.email);
        System.out.println("Username: "+this.username);
        System.out.println("Password: "+this.password);
        
    }

    
}
