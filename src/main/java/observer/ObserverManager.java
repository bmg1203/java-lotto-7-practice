package observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverManager {
    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(List<Integer> winningNumbers, int bonusNumber) {
        for (Observer observer : observers) {
            observer.update(winningNumbers, bonusNumber);
        }
    }
}