
// For party head ==============================

import java.util.*;
import java.io.*;

public class headMenu {

	static Vector cDetails = new Vector();
	static Vector cVoteDetails = new Vector();
	static ManageVector party_head = new ManageVector("head_details.txt");
	static ManageVector vote_record = new ManageVector("voting_record.txt");

	private static void AddDetails(int cid,String cn,String cdob,String cg,int ca,String cr) {
		CandidateDetails temp = new CandidateDetails(cid,cn,cdob,cg,ca,cr);
		cDetails.addElement(temp);
		System.out.println("Entry Success!");
	}


	public static void displayAllPass()	{
		CandidateVotingDetails temp2;
		cVoteDetails = vote_record.loadVector();

		System.out.println(" | Candidate ID | Name | Address | Phone No. | Email Add | ");
		for(int i = 0; i<cVoteDetails.size();i++) {
			temp2 =(CandidateVotingDetails)cVoteDetails.elementAt(i);
			System.out.println(" | " + temp2.cid + " | " + temp2.Name + " | " + temp2.Address + " | " + temp2.phone + " | " + temp2.Email + " | ");
		}
	}

	public static void AddMenu() throws java.io.IOException	{

		String cn;
		String cdob;
		String cg;
		int cid;
		int ca;
		String cr;

		Scanner in = new Scanner(System.in);

		System.out.println("Please Enter The Following Information --- ");
		System.out.println("Enter Candidate ID: ");
		cid = in.nextInt();
		System.out.println("Enter the Candidate's Name: ");
		cn = in.next();
		System.out.println("Enter Candidate date of birth: ");
		cdob = in.next();
		System.out.println("Enter Candidate's gender: ");
		cg = in.next();
		System.out.println("Enter Candidate age: ");
		ca = in.nextInt();
		System.out.println("Enter Candidate's Electoral Region: ");
		cr = in.next();
		AddDetails(cid,cn,cdob,cg,ca,cr);
	}

	public static void displayAll()	{
		CandidateDetails temp;

		System.out.println(" | Candidate ID. | Name | Date of Birth | Gender | Age | Region | ");
		for(int i = 0; i<cDetails.size();i++) {
			temp =(CandidateDetails)cDetails.elementAt(i);
			System.out.println(" | " + temp.cid + " | " + temp.cn + " | " + temp.cdob + " | " + temp.cg + " | " + temp.ca + " | " + temp.cr + " | ");
		}
	}

	private static void delDetails(int index) {
		cDetails.removeElementAt(index);
		System.out.println("Deletion Successful");
	}

	public static void delMenu() throws java.io.IOException	{
		int num;
		CandidateDetails temp = new CandidateDetails();

		System.out.println("Please Enter Candidate ID To Remove");
		Scanner in = new Scanner(System.in);
		num = in.nextInt();

		for(int i = 0; i<cDetails.size();i++) {
			temp =(CandidateDetails)cDetails.elementAt(i);
				if(temp.cid == num) {
						delDetails(cDetails.indexOf(temp));
				}
		}

		if(temp == null) {
			System.out.println("Entry Not Found");
		} else {
			System.out.println("Removal Successful");
		}

	}

	public static void saveEntry() {
		party_head.saveVector(cDetails);
		System.out.println("Entries Saved!");

	}

	public static void loadEntry() {
		cDetails = party_head.loadVector();
		System.out.println("Successfully Loaded!");
	}


	public static void showMenu() throws java.io.IOException {
		int myInput;

		do {
			System.out.println("\n===================================Welcome to Party Voting System===================================");
			System.out.println("1. Add New Candidate");
			System.out.println("2. View Candidate Details");
			System.out.println("3. Save Candidate Details");
			System.out.println("4. Load Condidate Details");
			System.out.println("5. View Voting Record");
			System.out.println("6. Delete A Candidate");
			System.out.println("7. Quit");
			System.out.println("Enter your choice to continue --- ");

			Scanner in = new Scanner(System.in);
			myInput=in.nextInt();

			if(myInput == 1) {
				AddMenu();
			} else if(myInput == 2) {
				displayAll();
			} else if(myInput == 3) {
				saveEntry();
			} else if(myInput == 4) {
				loadEntry();
			} else if(myInput == 5) {
			    displayAllPass();
			} else if(myInput == 6) {
				delMenu();
			}
		} while(myInput !=7);
		saveEntry();
		System.out.println("Thank you for Using The System!");
	}
}
