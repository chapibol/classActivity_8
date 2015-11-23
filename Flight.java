/**
 * Group Members: Luis Velascco, Larry Hong, Peter Alvarado Nunez.
 * Group Leader: Luis Velasco
 * Date: 11-05-2015
 * Course: IT 306 - 001
 * Class Activity 8
 */
package classActivity_8;

public class Flight {

    private String flightNumber;
    private boolean connectingFlight;
    private long connectionPeriod; 
    
    public Flight(String flightNumber, boolean connectingFlight){
        this.flightNumber = flightNumber;
        this.connectingFlight = connectingFlight;
    }
    public boolean setConnectionPeriod(long p){
    	if (p < PQEntry.DEFAULT_KEY) {
    		connectionPeriod = p;
    		return true;
    	}
    	else return false;
    }
    public long getConnectionPeriod() { return connectionPeriod; }
    
    public String getFlightNumber() {
        return flightNumber;
    }
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
    public boolean isConnectingFlight() {
        return connectingFlight;
    }
    public void setConnectingFlight(boolean connectingFlight) {
        this.connectingFlight = connectingFlight;
    }
    public String toString (){
    	
        return "F#"+flightNumber + ", Connection Period: " + connectionPeriod + ", is Connective?: " + (connectingFlight ? "Yes" : "No");
    }
}