package com.lxf.designPartten;

import java.util.ArrayList;

class Subject{
    private ArrayList<Observer> observers=new ArrayList();
    public void addObserver(Observer obj){
        observers.add(obj);
    }
    public void removeObserver(Observer obj){
        observers.remove(obj);
    }
    public void notify(String s){
        for(Observer obj:observers){
            obj.doWork(s);
        }
    }

}
interface Observer{
    public void doWork(String s);
}
class Task1 implements Observer{

    @Override
    public void doWork(String s) {
        System.out.println(String.format("接收到的数据为：%s,Task1开始干活",s));
    }
}
class Task2 implements Observer{

    @Override
    public void doWork(String s) {
        System.out.println(String.format("接收到的数据为：%s,Task2开始干活",s));
    }
}
public class ObserverPartten {
    public static void main(String[] args) {
        Subject s=new Subject();
        Observer task1=new Task1();
        Observer task2=new Task1();
        s.addObserver(task1);
        s.addObserver(task2);
        s.notify("sss");
    }
}
