package edu.umb.cs680.hw04;

public interface State {

    public abstract void login(EncryptedString password);

    public abstract void logout();
}
