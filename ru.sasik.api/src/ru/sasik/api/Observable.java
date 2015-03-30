package ru.sasik.api;

import java.util.Iterator;
import java.util.List;
import java.util.Observer;

/**
 * реализация Наблюдателя, почему то не заработала стандартная
 * все заработала, просто я баран, забыл проинициализовать в предках конструктор парента
 * !!можно удалить!!
 * @author sasik
 *
 */
@Deprecated
public class Observable {

	private List<Observer> observers;

	public List<Observer> getObservers() {
		return observers;
	}

	public void setObservers(List<Observer> observers) {
		this.observers = observers;
	}
	
	public void notifyObservers() {
		for (Iterator iterator = observers.iterator(); iterator.hasNext();) {
			Observer observer = (Observer) iterator.next();
			observer.update(null, null);
		}
	}
	
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
}
