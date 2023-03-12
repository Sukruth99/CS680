package edu.umb.cs680.hw04;

public class LoggedIn implements State{

    private SecurityContext ctx;
    public static LoggedIn instance;

    private LoggedIn(SecurityContext ctx) {
        this.ctx = ctx;
    }

    public static LoggedIn getInstance(SecurityContext ctx) {
        if (instance == null) {
            instance = new LoggedIn(ctx);
        }
        instance.ctx = ctx;
        return instance;
    }
    @Override
    public void login(EncryptedString password) {
        if(!ctx.isActive()) {
            ctx.changeState(LoggedOut.getInstance(ctx));
            ctx.login(password);
        }
    }

    @Override
    public void logout() {
        ctx.changeState(LoggedOut.getInstance(ctx));
    }
}
