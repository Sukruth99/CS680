package edu.umb.cs680.hw05.PrintingFramework;

import edu.umb.cs680.hw05.util.*;

public abstract class PrintJobExecutor {

    public void execute(PrintJob job, SecurityContext ctx, EncryptedString pwd) {
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
