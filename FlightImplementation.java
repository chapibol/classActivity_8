/**
 * Group Members: Luis Velascco, Larry Hong, Peter Alvarado Nunez.
 * Group Leader: Luis Velasco
 * Date: 11-05-2015
 * Course: IT 306 - 001
 * Class Activity 8
 */
package classActivity_8;

import javax.swing.JOptionPane;

public class FlightImplementation {

	public static void main(String[] args) {
		UnsortedPriorityQueue flightList = new UnsortedPriorityQueue();
		//Variable to store the response of the user to add more flights
		
		int userChoice = 0;
		
		do{
			//Prompt to ask the user if they want to add more flights. 
			userChoice = JOptionPane.showConfirmDialog(null, "Enter Flight Information?", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(userChoice == JOptionPane.YES_OPTION){
				//keep creating the flights and add them to flight list
				flightList.add(createFlight());
			}			
		}while(userChoice != JOptionPane.NO_OPTION);
		
		//print out all of the contents of the Flight list.
		while(!flightList.isEmpty()){
			System.out.println(flightList.removeMin().toString());
		}

	}
	
	/**
	 * Method to create a flight object by prompting the user to enter the flight information.
	 * @return Flight object
	 */
	public static Flight createFlight(){
		//Booleans to control the loops that prompt the user for flight information.
		boolean connectionValid = false, validFlightNum = false;
		long connectionPeriod = 0;
		String flightNumber;
		
		//Do while loop to prompt the user for a 4 digit flight number.
		do{
			flightNumber = JOptionPane.showInputDialog(null, "Enter a 4 digit Flight number ex. 1555");
			//If the flight number is the correct length then the loop can terminate.
			if(flightNumber.length() == 4){
				//For loop to check that all the characters entered by the user are numeric.
				for(int x = 0; x < 4; x++){
					if(!Character.isDigit(flightNumber.charAt(x))){
						//If a character is not numeric then this error is displayed and we terminate the loop to prompt the user again.
						JOptionPane.showMessageDialog(null, "The flight number can only contain numbers.", "ERROR Message", JOptionPane.ERROR_MESSAGE);
						validFlightNum = false;
						break;
					}else{
						validFlightNum = true;
					}
				}
			}
			//If the loop is not the correct length then display an error and prompt the user again.
			else{
				JOptionPane.showMessageDialog(null, "The flight number must be 4 digits.", "ERROR Message", JOptionPane.ERROR_MESSAGE);
				validFlightNum = false;
			}
		}while(!validFlightNum);
		
		int connectionChoice = JOptionPane.showConfirmDialog(null, "Does this flight have a connection?", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		boolean isConnective = connectionChoice == 0 ? true:false;
		
		//Do while loop to prompt the user for the connection period.
		do{
			//Try and catch to ensure the user enters a numeric value for the connection period.
			try{
				connectionPeriod = Long.parseLong(JOptionPane.showInputDialog(null, "Enter a connection period in minutes. ex.  120"));
				connectionValid = true;
			}catch(NumberFormatException e){
				//If the user enters a non-numeric value then an error is displayed and the user is prompted again.
				connectionValid = false;
				JOptionPane.showMessageDialog(null, "Error please enter a valid connection period.", "ERROR Message", JOptionPane.ERROR_MESSAGE);
			}
		}while(!connectionValid);
		
		Flight aFlight = new Flight(flightNumber, isConnective);
		aFlight.setConnectionPeriod(connectionPeriod);
		return aFlight;
	}	
}