package BusinessLayer;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Model {

    private static final ArrayList<User> users = new ArrayList<>();

    public Model()
    {
        int ok=0;
        for(User i:users)
        {
            if(i.getRole()==Role.ADMINISTRATOR)
                ok=1;
        }
        if(ok == 0)
        users.add(new User("George","UTCN",Role.ADMINISTRATOR));
    }

    public void addUser(String username,String password,Role role)
    {
        if(username.equals("") || username.equals(" ") || password.equals("") || password.equals(" "))
        {
            JOptionPane.showMessageDialog(null,
                    "Invalid username or password!",
                    "Error!",
                    JOptionPane.ERROR_MESSAGE);

            return;
        }
        for(User i: users)
        {
            if(i.getUsername().equals(username))
            {
                JOptionPane.showMessageDialog(null,
                        "This username is already taken!",
                        "Error!",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }
        }
        users.add(new User(username,password,role));
    }
    public int checkUser(String username,String password)
    {
        if(username.equals("") || username.equals(" ") || password.equals("") || password.equals(" "))
        {
            JOptionPane.showMessageDialog(null,
                    "Invalid username or password!",
                    "Error!",
                    JOptionPane.ERROR_MESSAGE);

            return -1;
        }

        for(User i: users)
        {
            if(i.getUsername().equals(username))
            {
                if(!i.getPassword().equals(password))
                {
                    JOptionPane.showMessageDialog(null,
                            "Invalid password!",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);

                    return -1;
                }
                else
                {
                    if(i.getRole() == Role.ADMINISTRATOR)
                        return 1;
                    else
                    {
                        if(i.getRole() == Role.EMPLOYEE)
                            return 2;
                        else
                        {
                            if(i.getRole() == Role.CLIENT )
                                return 3;
                        }
                    }
                }

            }
        }
        JOptionPane.showMessageDialog(null,
                "Invalid username or password!",
                "Error!",
                JOptionPane.ERROR_MESSAGE);
        return -1;
    }

    public int getUserID(String username,String password) {
        if(username.equals("") || username.equals(" ") || password.equals("") || password.equals(" "))
        {
            JOptionPane.showMessageDialog(null,
                    "Invalid username or password!",
                    "Error!",
                    JOptionPane.ERROR_MESSAGE);

            return -1;
        }

        for(User i: users) {
            if (i.getUsername().equals(username)) {
                if (!i.getPassword().equals(password)) {
                    JOptionPane.showMessageDialog(null,
                            "Invalid password!",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);

                    return -1;
                }
                else
                {
                    return i.getID();
                }
            }
        }
        return -1;
    }

    public static ArrayList<User> getUsers()
    {
        return users;
    }
    public static void loadUsers(ArrayList<User> users2)
    {
        users.addAll(users2);
    }

}
