
import java.util.Scanner;


public class BatteryService {
	
	private final static int UPPER_WEIGHT_LIMIT = 10 ;
	private final static int BATTERY_LIMIT = 15 ;
	private static double reminingbattery =0;
	
	
	public static void main(String[] args) {
		
	 reminingbattery =100 ;	//battery initialized to 100 
		
     Scanner sc = new Scanner(System.in); 
     
     String decider =null;
     
    do {
    	
    	  System.out.println("Enter robot walk");  
    	  double walk =sc.nextDouble();  
    			
    	 //instead of this we should  find the weight and battery through existing API
    	  
    	  double battery =100 ;//initially we are assuming robot is fully charged
    	     
    	  System.out.println("Enter robot weight");  
    	  double weight =sc.nextDouble();  
         
    	 
    	 if(battery < BATTERY_LIMIT ){
    		 
    		 System.out.println("bettery is less than 15 %"); 
    		 
    		 
    	 }
     
	     if(weight > UPPER_WEIGHT_LIMIT){
	    	 
	    	System.out.println("more than 10 Kg weight can not be carried"); 
 
	     }

	    
	     getRemainignBatteryPercent(walk , weight , battery);
	    	     
	     System.out.println("reminingbattery----=" + reminingbattery);
	     
	     System.out.println("do you want to continue Y/N");
	     decider =sc.next();  
	     
     }while(reminingbattery > 0 && "Y".equals(decider)) ;

   }

	
	private static  void  getRemainignBatteryPercent(double walk , double weight , double battery){
		//assuming walk comes in KM 
		if(walk>0){
			
			double batteryUsedPerKMwalk = 100/5 ;
			
			double betteryUsedForInputKM = batteryUsedPerKMwalk*walk ;
			
			System.out.println("betteryUsedForInputKM =" + betteryUsedForInputKM);
			
			if(reminingbattery > betteryUsedForInputKM){
			
			   reminingbattery = reminingbattery - batteryUsedPerKMwalk*walk ;

			}
			
		}
		
		if(weight>0 && reminingbattery > 0){
			
			double batteryUsedForInputWeight =(reminingbattery*weight*2)/100 ;
			
			System.out.println("batteryUsedForInputWeight =" + batteryUsedForInputWeight);

			
			if(reminingbattery > batteryUsedForInputWeight){
				
				reminingbattery = reminingbattery - batteryUsedForInputWeight;
			}

			
		}
		
		
	}
	    	 
}
	     


	

