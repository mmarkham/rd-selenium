package IO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import testCases.*;
import Main.*;

public class IO {

	public IO(){	
	}
	/*
	public void readConfig(){
		//Get the DOM Builder Factory
	    DocumentBuilderFactory factory = 
	    DocumentBuilderFactory.newInstance();

	    //Get the DOM Builder
	    DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    //Load and Parse the XML document
	    //document contains the complete XML as a Tree.
	    String currentFolder = System.getProperty("user.dir");
	    Document document = null;
		try {
			document = builder.parse(new FileInputStream(currentFolder+"/auto_config.xml"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
	    RootContext root = new RootContext();
	  
	    //Iterating through the nodes and extracting the data.
	    NodeList nodeList = document.getDocumentElement().getChildNodes();

	    for (int i = 0; i < nodeList.getLength(); i++) {
	       Node elderNode = nodeList.item(i);
	       if (elderNode.getNodeName() == "setup") {
		        
		       Setup setup = Setup.parse(elderNode);
		       root.addSetup(setup);
		   }
	       
	       else if (elderNode.getNodeName() == "edms") {
	    	   NodeList childNodes = elderNode.getChildNodes();
		        for (int j = 0; j < childNodes.getLength(); j++) {
		          Node cNode = childNodes.item(j);
		          if (cNode.getNodeName() == "edm"){
		        	  EDM edm = EDM.parse(cNode);
		        	  root.addEDM(edm);
		          }
		        }
	    	   
	       }
	       else if (elderNode.getNodeName()== "entSearches") {
	    	   NodeList childNodes = elderNode.getChildNodes();
		        for (int j = 0; j < childNodes.getLength(); j++) {
		          Node cNode = childNodes.item(j);
		          //ES es = new ES(null, null, null, null); 
		          if (cNode.getNodeName() == "es"){
		          ES es = ES.parse(cNode);
		          root.addES(es);
		          }
		        }
	       }
	       else if (elderNode.getNodeName()== "user") {
	    	   User user = User.parse(elderNode);
	    	   root.setUserName(user.toString()); 
	    	    
	       }
	       
	    }
	}// end ReadConfig()
	*/
	
	public void writeFile(String toXml, String fileName){
	    BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(fileName + ".xml"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try { 
	        out.write(toXml);
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	}//end writefile

	public String readFile(String path) throws IOException{
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))){

        	String sCurrentLine;
	while ((sCurrentLine = br.readLine()) != null) {
		sb.append(sCurrentLine);
		sb.append("\n");
    }

}

      return sb.toString();
}
}//end class
