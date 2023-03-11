package edu.umb.cs680.hw05.util;

public interface State {

    public abstract void login(EncryptedString password);

    public abstract void logout();
}
