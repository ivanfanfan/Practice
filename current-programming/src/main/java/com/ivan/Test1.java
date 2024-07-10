package com.ivan;


import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            People people = new People();
            people.start();
        }
        Thread.sleep(1000);
        for(Integer i :MailBox.getIds()){
            new Postman(i, "rs" + i).start();
        }
    }
}

class People extends Thread{

    @Override
    public void run() {
        GuardObject  guardObject = MailBox.createGuardObject();
        try {
            System.out.println("start to get resource =====================================");
            Object resource = guardObject.getResource(5000);
            System.out.println("id: " + guardObject.getId() + " " + resource + " =======================");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
class Postman extends Thread{
    private int id;
    private String resource;
    public Postman(int id, String resource){
        this.id = id;
        this.resource = resource;
    }

    @Override
    public void run() {
        System.out.println("postman to send resource+++++++++++");
        GuardObject guardObject = MailBox.getGuardObject(id);
        guardObject.setResource(resource);
    }
}
/*
one by one production and consume
 */
class MailBox{

    static Map<Integer,GuardObject> map = new ConcurrentHashMap<>();

    private static int id = 1;


    private synchronized static int generateId(){
        return id++;
    }

    public static GuardObject createGuardObject(){
        GuardObject guardObject = new GuardObject(generateId());
        map.put(guardObject.getId(),guardObject);
        return guardObject;
    }

    public static Set<Integer> getIds(){
        return map.keySet();
     }


    public static GuardObject getGuardObject(int id) {
        return map.remove(id);
    }
}
class GuardObject{
    private int id;
    private Object resource;

    public GuardObject(int i) {
        id = i;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getResource(long waitTime) throws InterruptedException {
        synchronized (this) {
            long now = System.currentTimeMillis();
            while (resource == null) {
                if (waitTime <= 0) {
                    System.out.println("waiting time out");
                    break;
                }
                wait(waitTime);
                waitTime = waitTime - (System.currentTimeMillis() - now);
            }
        }
        return resource;
    }

    public synchronized void setResource(Object resource){
        this.resource = resource;
        notifyAll();
    }


}
