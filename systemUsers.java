
// MAIN PROGRAM ==============================

import java.util.*;
import java.io.*;

public class systemUsers {

  	static ManageVector system1 = new ManageVector("login1.txt");
	static Vector systemuser1 = new Vector();

    public static void saveUser() {
		system1.saveVector(systemuser1);
	}

    public static void loadUser() {
		systemuser1 = system1.loadVector();
	}

    public static void addNewUser() throws java.io.IOException {
        System.out.println("Please Enter your Name: ");
		
		Scanner in = new Scanner(System.in);
        String name = in.next();
		
		
        System.out.println("Please Enter Your Password: ");
        String pass = in.next();
        System.out.println("Please choose one of the following:\n1. Party Head\n2. User");
        int n = in.nextInt();
        systemuser1.addElement(new Users(name,pass,n));
		
        saveUser();
    }

    public static void loginMenu() throws java.io.IOException {
		System.out.println("\n===================================LOGIN MENU===================================");
		System.out.println("Please Enter your Name: ");
		Scanner in = new Scanner(System.in);
		String Name = in.next();

		System.out.println("Please Enter your Password: ");
		String pass = in.next();

		Users Temp = new Users();

		for(int i=0;i<systemuser1.size();i++) {
			Temp = (Users)systemuser1.elementAt(i);
			if(Temp.Name.equals(Name) && Temp.Password.equals(pass)) {
				if(Temp.type == 1) {
	                headMenu mymenu = new headMenu();

					mymenu.loadEntry();
					mymenu.showMenu();
				} else if(Temp.type == 2) {
					userVoteMenu mymenu = new userVoteMenu();

					mymenu.loadEntry();
					mymenu.showMenu();
				} else {
					System.out.println("Wrong Credentials! Please try again.");
				}
			} else {
				System.out.println("Wrong Credentials! Please try again.");
			}
		}
	}

 	public static void main(String args[]) throws java.io.IOException {
	 	int input;
		Scanner b1 = new Scanner(System.in);
		do {
			System.out.println("\n===================================MAIN MENU===================================");
			System.out.println("1. Login for Existing Users");
			System.out.println("2. New User");
			System.out.println("3. Quit");
			System.out.println("Enter your choice to continue --- ");

			input=b1.nextInt();
			if(input == 1) {
				loginMenu();
			} else if(input == 2) {
				addNewUser();
			}
		}
		while(input!=3);
 	}
}


class Users implements Serializable {

	public String Name;
	public String Password;
	public int type;
	public Users() {
		// Constructor definition
	}
	public Users(String one, String two, int three)	{
		this.Name = one;
		this.Password = two;
		this.type = three;
	}
}
