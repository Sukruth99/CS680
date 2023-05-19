package edu.umb.cs680.hw16.observer;

public interface Observer<T> {
	public void update(Observable<T> sender, T event);
}
