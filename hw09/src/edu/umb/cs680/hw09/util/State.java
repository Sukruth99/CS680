package edu.umb.cs680.hw09.util;

public interface State {

    public abstract void login(EncryptedString password);

    public abstract void logout();
}
