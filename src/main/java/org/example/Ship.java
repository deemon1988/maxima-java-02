package org.example;

public class Ship extends Transport {
    public Ship(String name, int capacity, int speed, double costOfKm) {
        super(name, capacity, speed, costOfKm);
    }

    @Override
    float getPrice(City city) {
        float stoimost;
        if (city.isOnWater()) {return stoimost= (float) (getCostOfKm()* city.getDistance());} else{return 0;}
    }


}


