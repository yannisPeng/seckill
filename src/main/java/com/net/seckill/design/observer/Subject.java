package com.net.seckill.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author 10014994
 * @since 2021/1/26
 */
public class Subject {

    private int state;

    private List<Observer> allObservers = new ArrayList<>();

    public void register(Observer observer){
        this.allObservers.add(observer);
    }

    public void changeState(int newState){
        this.state = newState;
        this.notifyAllObservers();
    }

    private void notifyAllObservers() {
        for(Observer observer : allObservers){
            observer.update(this.state);
        }
    }

}
