package edu.umb.cs680.hw09.PrintingFramework;

import edu.umb.cs680.hw09.util.*;
import edu.umb.cs680.hw09.util.SecurityContext;

public abstract class PrintJobExecutor {

    protected Command job;
    protected SecurityContext ctx;


    public void execute(Command job, SecurityContext ctx, EncryptedString pwd) {
        this.ctx = ctx;
        this.job = job;
        doAuthentication(pwd, ctx);
        doAccessControl();
        doPrint();
        doExceptionHandling();
    }

    protected void doAuthentication(EncryptedString pwd, SecurityContext ctx) {

    }

    protected void doAccessControl() {

    }

    protected void doPrint() {
        System.out.print("Printing");
    }

    protected void doExceptionHandling() {

    }

    
}
