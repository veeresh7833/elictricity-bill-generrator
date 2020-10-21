package com.wipro.eb.service;

import com.wipro.eb.entity.Commercial;
import com.wipro.eb.entity.Domestic;
import com.wipro.eb.exception.InvalidConnectionException;
import com.wipro.eb.exception.InvalidReadingException;

public class ConnectionService {
	
	public boolean validate(int currentReading, int previousReading, String type)
				throws InvalidReadingException, InvalidConnectionException{
		
		if(currentReading-previousReading<0
				|| currentReading<0
				|| previousReading<0){
			throw new InvalidReadingException();
		}
		if( !(type.equals("Domestic") || type.equals("Commercial"))){
			throw new InvalidConnectionException();
		}
		return true;
	}

	public float calculateBillAmt(int currentReading, 
				int previousReading, String type){
		try{
			boolean status = validate(currentReading, previousReading, type);
			if(type.equals("Domestic")){
				float[] slabs = {2.3f, 4.2f, 5.5f};
				Domestic d = new Domestic(currentReading,
						previousReading, slabs);
				
				return d.computeBill();
			} else{
				
				float[] slabs = {5.2f, 6.8f, 8.3f};
				Commercial c = new Commercial(currentReading,
						previousReading, slabs);
				
				return c.computeBill();
			}
		} catch(InvalidReadingException e){
			return -1;
		} catch(InvalidConnectionException e){
			return -2;
		}
	}
	
	public String generateBill(int currentReading, 
			int previousReading, String type){
		float f = calculateBillAmt(currentReading, previousReading, type);
		
		if(f==-1){
			return "Incorrect Reading";
		} else if(f == -2){
			return "Invalid ConnectionType";
		} else{
			return "Amount to be paid:"+ f;
		}
			
		
	}
}











