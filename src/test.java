import com.group1.Controllers.AdminController;

public class test {
	
	public static void main(String[] args)  {
		AdminController ac = new AdminController();
		//boolean result = ac.AddAdminController("jose", "giants", "jose", "kelly", "Trader", 11);
		boolean result = ac.AddAdminController("", "giants", "ollie", "kelly", "PM", 16);

		System.out.println(result);
	}

}
