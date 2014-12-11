
// For candidate voting details to be shown to the party head ==============================

import java.util.*;
import java.io.*;

  public class CandidateVotingDetails extends CandidateDetails {
	
	int cid;
	String Name;
	String Address;
	int phone;
	String Email;

	public CandidateVotingDetails() {
		super();
	}

 	public CandidateVotingDetails(int cid, String name, String address, int ph, String email) {
		this.cid = cid;
		this.Name = name;
		this.Address = address;
		this.phone = ph;
		this.Email = email;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}
	public void setName(String Name1) {
		this.Name = Name1;
	}
	public void setAddress(String add) {
		this.Address = add;
	}
	public void setPhone(int ph) {
		this.phone = ph;
	}

	public void setEmail(String email) {
		this.Email = email;
	}
 }
