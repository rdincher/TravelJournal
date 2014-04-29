package TravelJournal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


public class MyDataBase implements DataBase {

	HashMap<String, Journal> journals = new HashMap<String, Journal>();
	ArrayList<MyUsers> users = new ArrayList<MyUsers>(); 
	ArrayList<String> wishList = new ArrayList<String>();
	ArrayList<MyTravelLog> plannedTrip = new ArrayList<MyTravelLog>();
	MyDataBase()
	{
		
	}
	@Override
	public Users getUser(String name, String password) {

		for(int i = 0; i < users.size(); i++){
			if(users.get(i).password.equals(password) && users.get(i).username.equals(name)){
				return users.get(i);
			}
		}
		return null;
	}

	@Override
	public Users getUser(String userName) {
		for(int i = 0; i < users.size(); i++){
			if(users.get(i).username.equals(userName)){
				return users.get(i);
			}
		}
		return null;
	}

	@Override
	public boolean putUser(Users u) {
		users.add((MyUsers) u);
		return true;
	}

	@Override
	public Journal getJournal(String name) {
		//return journals.get(name);
		Collection<Journal> theJournal = journals.values();
		for(Journal j : theJournal)
		{
			if(j.getName().equals(name))
				return j;
		}
		return null;
	}

	@Override
	public Journal getJournal(int id) {
		
		return journals.get(id);
	}

	@Override
	public boolean putJournal(Journal j) {
		String key = j.getName();
		journals.put(key, j);
		return false;
	}
	
	@Override
	public List<Journal> getAllJournals() {
		
		Collection<Journal> theJournal = journals.values();
		List<Journal> j = (List<Journal>) theJournal;
		return j;
	}
	@Override
	public boolean storeWishList(String destination) {
		boolean wish = wishList.add(destination);
		return wish;
	}
	@Override
	public boolean storeFutureTrip(TravelLog tl) {
		
		boolean trip = plannedTrip.add((MyTravelLog) tl);
		return trip;
	}
	@Override
	public boolean removeJournal(int id) {
		
		Journal j = journals.remove(id);
		if(j == null)
			return false;
		else
			return true;
	}
	@Override
	public List<String> viewWishList() {
		
		return wishList;
	}
}
