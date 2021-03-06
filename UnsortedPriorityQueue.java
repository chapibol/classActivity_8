/**
 * Group Members: Luis Velascco, Larry Hong, Peter Alvarado Nunez.
 * Group Leader: Luis Velasco
 * Date: 11-05-2015
 * Course: IT 306 - 001
 * Class Activity 8
 */
package classActivity_8;

import java.util.*;

public class UnsortedPriorityQueue  {
	private LinkedList<PQEntry> queue;
	
	public UnsortedPriorityQueue(){
		queue = new LinkedList<PQEntry>(); 
	}
	
	public void add(Flight p){
		PQEntry entry = new PQEntry(); 
		entry.setValue(p); 
		queue.add(entry);
	}
	
	public PQEntry removeMin(){
		if(queue.isEmpty()){
			System.out.println("The queue is empty.");
			return null; 
		}
		else{
			int min = 0; 
			for(int i= 1; i < queue.size(); i++){
				if(queue.get(min).getKey() > queue.get(i).getKey()) 
					min = i;
				else if(queue.get(min).getKey() == queue.get(i).getKey()){
					if(min>i) min = i;
				}
				
			}
			
			PQEntry minEntry = queue.get(min);
			queue.remove(min);
			return minEntry;
		}
		
	}

	public boolean isEmpty(){
		return queue.isEmpty();
	}
	
	public int size(){
		return queue.size();
	}	
}