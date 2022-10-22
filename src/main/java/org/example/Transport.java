package org.example;

public class Transport {

    private  String name;
    private int capacity;
    private int speed;
    private double costOfKm;

    public Transport(String name, int capacity, int speed, double costOfKm) {
        this.name = name;
        this.capacity = capacity;
        this.speed = speed;
        this.costOfKm = costOfKm;
    }


    public void printName() {
        System.out.println("Транспорт: "+getName());
        System.out.println("Грузоподъёмность: "+getCapacity()+" Кг");
        System.out.println("Скорость: "+getSpeed()+" Км/ч");
        System.out.println("Стоимость за километр: "+getCostOfKm()+" ");
    }

    public float getPrice(City city) {

        return (float) (city.getDistance() * getCostOfKm());    //обращение к свойству класса не напрямую, а через getter
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getCostOfKm() {
        return costOfKm;
    }

    public void setCostOfKm(double costOfKm) {
        this.costOfKm = costOfKm;
    }


}
