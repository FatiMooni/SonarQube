

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Subject implements Serializable{
	
	 private List<Observer> observers = new ArrayList<Observer>();
	 private String state;


	public void attach(Observer observer) {
		observers.add(observer);
	}
	public void notifiyAllObserver(){
		for(Observer observer:observers) {
			observer.update();
		}
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
		notifiyAllObserver();
	}
	   

}
