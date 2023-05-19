package edu.umb.cs680.hw09.util;

public class SecurityContext {
    private State state;
    private User userDetails;

    public SecurityContext(User userDetails) {
        this.userDetails = userDetails;
        this.state = LoggedOut.getInstance(this);
    }

    public void changeState(State state) {
        this.state = state;
    }

    public boolean isActive() {
        if (this.state instanceof LoggedIn) {
            return true;
        } else {
            return false;
        }
    }

    public User getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(User userDetails) {
        this.userDetails = userDetails;
    }

    public State getState() {
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void login(EncryptedString password) {
        this.state.login(password);
    }

    public void logout() {
        this.state.logout();
    }

    public static void main(String[] args) {
        User details = new User();
        SecurityContext user = new SecurityContext(details);
        EncryptedString password = new EncryptedString();
        user.login(password);
        System.out.println(user.getState() instanceof LoggedIn);
        user.logout();
        System.out.println(user.getState() instanceof LoggedOut);
    }
}
