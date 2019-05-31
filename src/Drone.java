

public class Drone {

	static int Αltitude = 0;
	static int Temperature = 0;
	static int Wind_Speed = 0;
	static int Drone_Speed = 0;
	static int Level_of_Battery = 0;
	static enum Engine_Status { Exellant, Good, Bad, Dead};
	static enum Signal_Status { Exellant, Good, Bad, Lost};
	static enum Reboot_Status { Succeed, Failled};

	static String Longitude;
	static String Latitude;

	
	public Drone(String Drone_id){
		
		Αltitude = 1; // set some Status Values
		Temperature = 2; // set some Status Values
		Wind_Speed = 3; // set some Status Values
		Drone_Speed = 4; // set some Status Values
		Level_of_Battery = 5; // set some Status Values
		
	}
	
	
	public void CommunicationSystems(String Drone_id){
		
		/* This method establish the connection between 
		 * the drone and the distribute_base. 
		 * 
		 * Transfer commands from the base to Drone and
		 * also transfer the data that drone collecting 
		 * with his sensors and cameras*/
		
	} 
	
	///=================================================================///
	
	public void CommunicationSystems_Checking() {
		
	  /* Mark the CheckBox with a tick on Success
	   *                or with a  X   on Fail  */
		
	}
	
	public void Engine_Checking() {
		
	  /* Mark the CheckBox with a tick on Success
	   *                or with a  X   on Fail  */
		
	}
	
	public void Flying_Componets_Checking() {
		
		/* Mark the CheckBox with a tick on Success
		 *                or with a  X   on Fail  */
	}
	
	public void Sensors_Checking() {
		
		/* Mark the CheckBox with a tick on Success
		 *                or with a  X   on Fail  */
	}
	
	public void Battery_Checking() {

		/* Mark the CheckBox with a tick on Success
		 *                or with a  X   on Fail  */
	}
	
	
	public void Emergency_Landing_System_Checking() {
		
		/* Mark the CheckBox with a tick on Success
		   *                or with a  X   on Fail  */
	}
	
	
	
	
	public  Reboot_Status Emergency_System_Reboot() {
		
		return Reboot_Status.Failled;
	}
	
	
	
	
	public Drone.Signal_Status CommunicationSystems_Status() {
		
		return Signal_Status.Exellant;
	}
	
	public Drone.Engine_Status Engine_Status() {
		
		return Engine_Status.Good;
	}
	
	public void Flying_Componets_Status() {
		
	}
	
	public int[] Sensors_Status() {
		
		int Sens_Log[] = new int[4];

		Sens_Log[0] = Αltitude;
		Sens_Log[1] = Temperature; 
		Sens_Log[2] = Wind_Speed;
		Sens_Log[3] = Drone_Speed;

		
		return Sens_Log;
	}
	
	public int Battery_Status() {
	
		return Level_of_Battery;
	}
	

	
	
}
