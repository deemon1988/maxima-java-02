package org.example;

import org.example.City;
import org.example.Transport;

public class Logistics {
    private Transport[] vehicles;

    public Logistics(Transport... vehicles) {
        this.vehicles = vehicles;
    }

    public Transport[] getVehicles() {
        return vehicles;
    }

    public void setVehicles(Transport[] vehicles) {
        this.vehicles = vehicles;
    }


    public Transport getShipping(City city, int weight, int time) {
        Transport vehicle = null;
        for (Transport transport : getVehicles()) {
            if (isShippingAvailable(transport, city, weight, time)) {
                if (vehicle == null) {
                    vehicle = transport;
                } else {
                    if ((transport.getPrice(city)) < vehicle.getPrice(city)) {
                        vehicle = transport;
                    }
                }
            }
        }
        System.out.println(vehicle.getName());
        return vehicle;

    }

    /* public Transport getShipping(City city, int weight, int time)  {
          Transport result = new NullTransport();
          for (Transport vehicle: getVehicles()) {
              if (isShippingAvailable(vehicle, city, weight, time) && vehicle.getPrice(city) < result.getPrice(city)){
                  result = vehicle;
              }
          }
          return  result instanceof NullTransport ? null : result;
      }*/
    private boolean isShippingAvailable(Transport transport, City city, int weight, int time) {
      /* boolean isReachable = transport.getPrice(city)>0;
       boolean isNotOverLoaded = transport.getCapacity()>=weight;
        boolean canShipInTime = city.getDistance()/ transport.getSpeed()<=time;

        return isReachable && isNotOverLoaded && canShipInTime && !transport.isRepairing();*/


        float deliveryIsPossible = transport.getPrice(city);
        int requiredLoadCapacity = transport.getCapacity();
        int deliveryOnTime = city.getDistance() / transport.getSpeed();

        if (deliveryIsPossible > 0 && requiredLoadCapacity >= weight && deliveryOnTime <= time && !transport.isRepairing()) {
            return true;
        }
        return false;
    }

}
