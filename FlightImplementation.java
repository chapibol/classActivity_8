package classActivity_8;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JOptionPane;

public class FlightImplementation {

	public static void main(String[] args) {
		UnsortedPriorityQueue flightList = new UnsortedPriorityQueue();
		int userChoice = 0;
		
		do{
			userChoice = JOptionPane.showConfirmDialog(null, "Enter flights?", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(userChoice == JOptionPane.YES_OPTION){
				flightList.add(createFlight());//keep creating the flights and add them to flight list
			}			
			
		}while(userChoice != JOptionPane.NO_OPTION);
		
		
		//print out all of the contents of the Flight list.
		while(!flightList.isEmpty()){
			System.out.println(flightList.removeMin().toString());
		}

	}
	
	
	public static Flight createFlight(){
		String flightNumber = JOptionPane.showInputDialog(null, "Enter a 4 digit Flight number ex. 1555");
		int connectionChoice = JOptionPane.showConfirmDialog(null, "Does this flight have a connection?", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		boolean isConnective = connectionChoice == 0 ? true:false;
		boolean connectionValid = false;
		long connectionPeriod = 0;
		do{
			try{
				connectionPeriod = Long.parseLong(JOptionPane.showInputDialog(null, "Enter a connection period in minutes. ex.  120"));
				connectionValid = true;
			}catch(NumberFormatException e){
				connectionValid = false;
				JOptionPane.showMessageDialog(null, "Error please enter a valid connection period.");
			}
			
		}while(connectionValid == false);
		
		
		Flight aFlight = new Flight(flightNumber, isConnective);
		aFlight.setConnectionPeriod(connectionPeriod);
		return aFlight;
	}	
}
