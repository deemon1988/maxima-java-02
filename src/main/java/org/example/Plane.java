package org.example;

public class Plane  extends Transport{

    public Plane(String name, int capacity, int speed, double costOfKm) {
        super(name, capacity, speed, costOfKm);
    }

    @Override
    public float getPrice(City city) {
        if (city.isHasAirport()) {return super.getPrice(city);}
        else {return 0;}



    }
}
