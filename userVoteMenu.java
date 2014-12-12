
// For users ==============================

import java.util.*;
import java.io.*;

public class userVoteMenu {

	static Vector userDetails = new Vector();
	static Vector uDetails = new Vector();
	static ManageVector vote_record = new ManageVector("voting_record.txt");
	static ManageVector party_head = new ManageVector("head_details.txt");

	private static void AddVoteDetails(int cid, String personName, String personAdd, int personPhone, String personEmail) {

	    uDetails = party_head.loadVector();
		CandidateVotingDetails temp2 = new CandidateVotingDetails(cid,personName,personAdd,personPhone,personEmail);		
		userDetails.addElement(temp2);
		saveEntry();
		System.out.println("Entry Successful!");
	}

	public static void AddResMenu() throws java.io.IOException {

		int cid;
		String pName;
		String pAdd;
		int pPhno;
		String pEmail;

		System.out.println("Please Enter The Following Info --- ");
		System.out.println("Enter Candidate ID: ");
		cid = read.GetInt();
		System.out.println("Enter your name: ");
		pName = read.GetString();
		System.out.println("Enter your complete address: ");
		pAdd = read.GetString();
		System.out.println("Enter your phone number: ");
		pPhno = read.GetInt();
		System.out.println("Enter your email address: ");
		pEmail = read.GetString();
		AddVoteDetails(cid,pName,pAdd,pPhno,pEmail);
	}

	public static void displayAllPass()	{
		CandidateVotingDetails temp2;

		System.out.println(" | Candidate ID | Name | Address | Phone No. | Email Add | ");

		for(int i = 0; i<userDetails.size();i++) {
			temp2 =(CandidateVotingDetails)userDetails.elementAt(i);
			System.out.println(" | " + temp2.cid + " | " + temp2.Name + " | " + temp2.Address + " | " + temp2.phone + " | " + temp2.Email + " | ");
		}
	}


	public CandidateDetails get(int num) {

		CandidateDetails temp = new CandidateDetails();
		CandidateDetails temp2 = new CandidateDetails();

		uDetails = party_head.loadVector();

		for(int i = 0;i<uDetails.size();i++) {
			temp2 = (CandidateDetails)uDetails.elementAt(i);
			if(temp2.cid == num) {
					temp = temp2;
			}
		}
		return temp;
	}

	public static void cancelVote() throws java.io.IOException {

		String Name;
		String Address;

		uDetails = party_head.loadVector();

		System.out.println("Please Enter the Following information to cancel your vote");
		System.out.println("Please Enter your Name: ");
		Name = read.GetString();
		System.out.println("Please Enter your Address: ");
		Address = read.GetString();
		CandidateVotingDetails temp = new CandidateVotingDetails();

		for(int i=0;i<userDetails.size();i++) {
			temp = (CandidateVotingDetails)userDetails.elementAt(i);

			if(temp.Name.equals(Name) && temp.Address.equals(Address)) {
				userDetails.removeElementAt(userDetails.indexOf(temp));
			}
		}
	}

	public static void searchResEntry() throws java.io.IOException {

		String Name;
		String Address;

		System.out.println("Please enter your following information for your voting details: ");
		System.out.println("Enter Name: ");
		Name = read.GetString();
		System.out.println("Enter Address: ");
		Address = read.GetString();
		System.out.println(" | Candidate ID | Name | Address | Phone No | Email | ");

		CandidateVotingDetails temp2 = new CandidateVotingDetails();

		for(int i=0;i<userDetails.size();i++) {
			temp2 = (CandidateVotingDetails)userDetails.elementAt(i);

			if(temp2.Name.equals(Name) && temp2.Address.equals(Address)) {
				System.out.println(" | " + temp2.cid + " | " + temp2.Name + " | " + temp2.Address + " | " + temp2.phone + " | " + temp2.Email + " | ");
			}
		}
	}

	public static void searchEntry() throws java.io.IOException {

		int cid;
		CandidateDetails temp;

		System.out.println("Enter Candidate Id: ");
		cid = read.GetInt();

        uDetails = party_head.loadVector();

		System.out.println(" | Candidate ID | Name | Date of Birth | Gender | Age | Region | ");

		System.out.println("");
			for(int i = 0; i<uDetails.size();i++) {
				temp =(CandidateDetails)uDetails.elementAt(i);
            	if(temp.cid == cid)						{
					System.out.println(" | " + temp.cid + " | " + temp.cn + " | " + temp.cdob + " | " + temp.cg + " | " + temp.ca + " | " + temp.cr + " | ");
				}
			}
	}

	public static void saveEntry() {
		vote_record.saveVector(userDetails);
		System.out.println("Saved Successfully!");
	}


	public static void loadEntry() {
		userDetails = vote_record.loadVector();
		System.out.println("Loaded Successfully!");
	}


	public static void showMenu() throws java.io.IOException {
		int myInput;

		do {
			System.out.println("\n===================================WELCOME TO PARTY VOTING SYSTEM===================================");
			System.out.println("1. Vote for Candidate");
			System.out.println("2. Cancel Vote");
			System.out.println("3. View Candidates");
			System.out.println("4. Voting History");
			System.out.println("5. Quit");

			System.out.println("Enter your choice!");
			myInput=read.GetInt();

			if(myInput == 1) {
				AddResMenu();
			} else if(myInput == 2)	{
				cancelVote();
			} else if(myInput == 3)	{
				searchEntry ();
			} else if(myInput == 4)	{
				searchResEntry();
			}
		}
		while(myInput !=5);

		saveEntry();

		System.out.println("Thank you for Using The System!");

	}

}