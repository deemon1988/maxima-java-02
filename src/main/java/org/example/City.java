package org.example;

public class City {                     // сделать класс приватным
    private  String name;
    private int distance;
    boolean hasAirport;
    boolean isOnWater;

    public City(String name, int distance, boolean hasAirport, boolean isOnWater) {
        this.name = name;
        this.distance = distance;
        this.hasAirport = hasAirport;
        this.isOnWater = isOnWater;
    }

    public City(String name, int distance) {
        this.name = name;
        this.distance = distance;
        this.isOnWater = true;
        this.hasAirport = false;
    }

    /*public void printName() {
       System.out.println("Город: "+getName()+" - "+getDistance()+" километров");
   }*/


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean isHasAirport() {
        return hasAirport;
    }
    public void setHasAirport(boolean hasAirport) {
        this.hasAirport = hasAirport;
    }

    public boolean isOnWater() {
        return isOnWater;
    }
    public void setOnWater(boolean onWater) {
        isOnWater = onWater;
    }
}




