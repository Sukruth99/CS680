package edu.umb.cs680.hw05.util;

public class LoggedOut implements State {

    private SecurityContext ctx;
    private static LoggedOut instance;

    private LoggedOut(SecurityContext ctx) {
      this.ctx = ctx;
    }

    public static LoggedOut getInstance(SecurityContext context) {
        if (instance == null) {
            instance = new LoggedOut(context);
        }
        instance.ctx = context;
        return instance;
    }


    @Override
    public void login(EncryptedString password) {
        if (Authenticator.authenticate(ctx, password)) {
            ctx.changeState(LoggedIn.getInstance(ctx));
        }
    }

    @Override
    public void logout() {
        System.out.println(".....loggging out.....");
    }
}
