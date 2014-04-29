package TravelJournal;

import java.util.Date;

public class MyTravelLog implements TravelLog {

	String destination = "";
	int id = 0;
	Date date;
	String departurePoint = "";
	String travelMethod = "";
	String locationWeather = "";
	int distance = 0;
	int myRating = 0;
	
	@Override
	public boolean modifyTravelLog(String field, String toChange) {
		boolean success = true;
		if(field == "departurePoint")
			departurePoint = toChange;
		else if(field == "travelMethod")
			travelMethod = toChange;
		else if(field == "locationWeather")
			locationWeather = toChange;
		else
			success = false;
		return success;
	}

	@Override
	public int create(String destination, Date date) {
		// TODO Auto-generated method stub
		this.destination = destination;
		this.date = date;
		id++;
		return id;
	}
	
	@Override
	public int getData() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TravelLog createNew(String destination) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getDistance() {
		
		return distance;
	}

	@Override
	public boolean rateTrip(int rating) {
		
		myRating = rating;
		return true;
	}
	
	public int getRating()
	{
		return myRating;
	}
	
	public Date getDate()
	{
		return date;
	}

}
