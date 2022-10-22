package org.example;

public class Ship extends Transport{
    public Ship(String name, int capacity, int speed, double costOfKm) {
        super(name, capacity, speed, costOfKm);
    }

        @Override
  public float getPrice(City city) {
        if(!city.isOnWater()) {return 0;}
        else {
            return super.getPrice(city);
        }
        }
}
