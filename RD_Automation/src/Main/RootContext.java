package Main;
import java.util.ArrayList;
import java.util.List;

import testCases.*;


public class RootContext {

	public static List<Discovery_Matter> edmList;
	public static List<Enterprise_Search> esList;
	public static List<Setup> setupList;
	public static List<User> userList;
	public static String userName;
	
	//collect class objects (from parsing) into ArrayLists
	public RootContext() {
			edmList   = new ArrayList<>();
			esList    = new ArrayList<>();
			setupList = new ArrayList<>();
	}
	
	public void addEDM( Discovery_Matter toAdd) {
			edmList.add( toAdd );
	}
	
	public void addES( Enterprise_Search toAdd ) {
			esList.add( toAdd );
	}
	
	public void addSetup( Setup toAdd ) {
			setupList.add(toAdd);
	}
	
	public void addUser( User toAdd ) {
			userList.add(toAdd);
	}
	public void setUserName (String u) {
		    userName = u;
	}
	public String getUserName(){
		return userName;
	}

}
