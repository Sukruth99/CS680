package edu.umb.cs680.hw05.ModelABC;

import edu.umb.cs680.hw05.util.*;
import edu.umb.cs680.hw05.PrintingFramework.*;

public class ModelABC extends PrintJobExecutor{

	@Override
	public void doAuthentication(EncryptedString pwd, SecurityContext ctx) {
		ctx.login(pwd);
		if (!(ctx.isActive() && ctx.getState() instanceof LoggedIn)) {
			throw new RuntimeException("wrong password");
		}

	}
    
}
