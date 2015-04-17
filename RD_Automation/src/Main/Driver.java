package Main;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;

import testCases.*;

import com.thoughtworks.xstream.XStream;

import IO.IO;

public class Driver {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String read = null;
		IO io = new IO();
		String fileName = null;
		//Discovery_Matter e = new Discovery_Matter();
		test e = new test();
		//WebDriver_Execute webdrive = new WebDriver_Execute(e);
		XStream xstream = new XStream();
		
		String xml = xstream.toXML(e);
		

		io.writeFile(xml, "outfilename");
		
		FileInputStream fis = new FileInputStream("outfilename.xml");
	    ObjectInputStream in = xstream.createObjectInputStream(fis);

	    test edm = (test)in.readObject();
	    //User us = (User)in.readObject();
	    System.out.println(edm.name);
	    //System.out.println(us.getUserName());
		
		/*
		XMLtest test = new XMLtest();
		User u = new User("User Name");
		
		xstream.alias("EDM", XMLtest.class);
		xstream.alias("User", User.class);
		
		String xml = xstream.toXML(test);
		xml += "\n";
		xml += xstream.toXML(u);
		
		io.writeFile(xml, "outfilename");
		
		
		
		
		XMLtest test2 = (XMLtest)xstream.fromXML(read);
		
	}*/
	
	

	}
}
