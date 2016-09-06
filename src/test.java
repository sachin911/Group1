import com.group1.Controllers.AdminController;

public class test {
	
	public static void main(String[] args)  {
		AdminController ac = new AdminController();
		//boolean result = ac.AddAdminController("jose", "giants", "jose", "kelly", "Trader", 11);
		boolean result = ac.EditAdminController("ryan", "giants", "ryan", "kelly", "Trader", 16);

		System.out.println(result);
	}

}
