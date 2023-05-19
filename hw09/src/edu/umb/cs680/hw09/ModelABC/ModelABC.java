package edu.umb.cs680.hw09.ModelABC;

import edu.umb.cs680.hw09.util.*;
import edu.umb.cs680.hw09.PrintingFramework.*;

public class ModelABC extends PrintJobExecutor{

	@Override
	public void doAuthentication(EncryptedString pwd, SecurityContext ctx) {
		ctx.login(pwd);
		if (!(ctx.isActive() && ctx.getState() instanceof LoggedIn)) {
			throw new RuntimeException("wrong password");
		}
	}

	@Override
	public void doPrint() {
		if (ctx.getState() instanceof LoggedIn) {
			job.execute();
		}
	}
    
}
