package com.group1.Controllers;

import java.sql.SQLException;
import java.util.List;

import com.group1.Services.LoginService;
import com.group1.Services.pmtradeservice;

public class PmtradeController {

static pmtradeservice ls = new pmtradeservice();
	
	

	public List<String> callpmtradeservice(int pid) throws SQLException {
		return ls.pmtraderetrieval(pid);
	}

}
