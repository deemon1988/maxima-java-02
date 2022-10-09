package org.example;

public class City {
    private  String name;

    public int distance;

    public City(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

   public void printName() {
       System.out.println("Город: "+getName()+" - "+getDistance()+" километров");
   }


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
}




