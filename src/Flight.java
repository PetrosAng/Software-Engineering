
public class Flight extends Drone{

	

	
   public Flight(String Drone_id) {
		super(Drone_id);
		
	}
   
   public void GPS_Setup(int Latitude, int Longtitude, int Radius) {
	   
	   /* This method creates a circle with Center(Latitude, Longitude)*
	    * and Radius= radius km, this method doesn't let the drone to fly
	    * out of this circle.                                          */
   }
   
   
   public void Engine_Throttle () {
	   
	   /* This method controlling the flow of fuel or power to the engine.
	    * As result this method controls the speed of the drone.       */
   }
   
   public void Left_Wing() {
	   
	   /* This method take as input aerodynamics parameters    *
	    * and defines the angle of the left wing. As a result  *
	    * has to maintaining the stability of the drone        */   
   }
   
   public void Right_Wing() {
	   

	   /* This method take as input aerodynamics parameters    *
	    * and defines the angle of the right wing. As a result  *
	    * has to maintaining the stability of the drone        */
   }
   
   public void Tail_Wing() {
	   

	   /* This method take as input aerodynamics parameters    *
	    * and defines the angle of the tail wing. As a result  *
	    * has to maintaining the stability of the drone        */
   }
   
   
   public void AutoPilot(int Latitude, int Longtitude, int Radius) {
	   
	   GPS_Setup(0,0,0);
	   
	   Engine_Throttle();
	   
	   Left_Wing();
	   
	   Right_Wing();
	   
	   Tail_Wing();
	   
   }
   
   
   public void Remote_Control_Flight(/*take input parameters by a joy-stick from base */) {
	   
	   /* The input for the methods below comes from User */
	   
	   Engine_Throttle();
	   
	   Left_Wing();
	   
	   Right_Wing();
	   
	   Tail_Wing();
	   
	   
   }

   public void ELS_Activation() {
		
		//Emergency Landing System Activation
	   
	   FindSpotToFall(Latitude,Longitude);
		
		Latitude = "";
	    Longitude = "";
	    
	   Open_Parachutes();
	}


   public void FindSpotToFall(String x, String y) {
	
	   /*Examine the the perfect spot for the emergency landing.
	    * The algorithm have to find the best place for landing, 
	    * which will cause fewer consequences*/
   }

   public void Open_Parachutes() {}
   
   

}
