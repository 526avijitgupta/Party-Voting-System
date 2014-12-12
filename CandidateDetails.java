
// For candidate details to be entered by the head ==============================

import java.util.*;
import java.io.*;

public class CandidateDetails implements Serializable {
	
	public int cid;
	public String cn;
	public String cdob;
	public String cg;
	public int ca;
	public String cr;

    public CandidateDetails() {
	    super();
	}

	public CandidateDetails(int cid, String cn, String cdob, String cg, int ca, String cr) {
		this.cn = cn;
		this.cdob = cdob;
		this.cg = cg;
		this.cid = cid;
		this.ca = ca;
		this.cr =cr;
	}

	// Polymorphism
	public void setcid(int cid) {
		this.cid = cid;
	}

	public void setNum(String Num) {
		this.cn = Num;
	}

	public void setcdob(String CDate) {
		this.cdob = CDate;
	}

	public void setcg(String cg) {
		this.cg = cg;
	}

	public void setca(int ca) {
		this.ca = ca;
	}

	public void setcr(String cr) {
		this.cr = cr;
	}

}
