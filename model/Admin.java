package model;

public class Admin {
    String Email;
    String Pass;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }
    public boolean isAdmin(String Email, String Pass)
    {
        if (Email.equals("SchoolSystem@12") && Pass.equals("123456")) {
            return true;
       }
       else
           return false;
    }
}
