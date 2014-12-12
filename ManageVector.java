
// For file input output ==============================

import java.util.*;
import java.io.*;

public class ManageVector {

	public Vector myVector = new Vector();
	public String filePath;

	public ManageVector(String file) {
		this.filePath = file;
	}

	public void saveVector(Vector temp)	{
		try {
			ObjectOutputStream saveObject = new ObjectOutputStream(new FileOutputStream(filePath));
		    saveObject.writeObject(temp);
		    saveObject.close();
	   	}
	    catch(IOException e){
	    	System.out.print(e.toString());
	    }
	}

	public Vector loadVector()	{
		try	{
			ObjectInputStream loadObject = new ObjectInputStream(new FileInputStream(filePath));
			myVector = (Vector)(loadObject.readObject());
		} catch(FileNotFoundException e1) {
			System.out.print(e1.toString());
		} catch(ClassNotFoundException e2) {
			System.out.print(e2.toString());
		} catch(IOException e) {
			System.out.print(e.toString());
		}

		return myVector;
	}

}
