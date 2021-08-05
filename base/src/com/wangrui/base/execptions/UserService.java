package com.wangrui.base.execptions;

public class UserService {

	public boolean login(String name, String pwd) throws LoginException {
		if (null==name || null==pwd) {
			LoginException ex = new LoginException("用户名或密码为空");
			throw ex;
		}
		
		boolean ok = false;
		
		if("admin".equals(name) && "123456".equals(pwd)) {
			ok = true;
		}
		
		return ok;
	}
}
