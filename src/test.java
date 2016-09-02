import com.group1.Controllers.AdminController;
import com.group1.Controllers.PMController;
import com.group1.Daos.Jdbc;

public class test {
	
	public static void main(String[] args)  {
//		Jdbc jdbc = new Jdbc();
//		jdbc.getCon();
//		AdminController ac = new AdminController();
		PMController pmc = new PMController();
		//boolean result = ac.AddAdminController("jose", "giants", "jose", "kelly", "Trader", 11);
		//boolean result = ac.AddAdminController("", "giants", "ollie", "kelly", "PM", 16);
		boolean result = pmc.createPMBrokerOrder(100, 5, 5, "BUY", "AAPL", "ROTH-IRA", "USD", "LIMIT", 110, 0);
		System.out.println(result);
		
	}

}
