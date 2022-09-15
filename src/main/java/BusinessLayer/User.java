package BusinessLayer;

import java.io.Serializable;

public class User implements Serializable {
    private final String username;
    private final String password;
    private final Role role;
    private static int contor=1;
    private final int ID;

    public User(String username,String password,Role role)
    {
        this.password=password;
        this.username=username;
        this.role=role;
        if(this.role==Role.ADMINISTRATOR)
        {
            this.ID=contor;
        }
        else
        {
            contor++;
            this.ID=contor;
        }
    }

    public String toString()
    {
        return this.username+" "+this.role;
    }
    public String getUsername()
    {
        return this.username;
    }
    public String getPassword()
    {
        return this.password;
    }

    public Role getRole() {
        return role;
    }
    public int getID()
    {
        return this.ID;
    }
    public static int getContor()
    {
        return contor;
    }
    public static void setContor(int c)
    {
        contor=c;
    }
}
