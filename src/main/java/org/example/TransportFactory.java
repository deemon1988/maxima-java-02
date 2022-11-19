package org.example;


public class TransportFactory {

    Transport newTransport = null;

    Transport getTransport(City city, int weight, int hours) {
        final String SHIP_NAME = "Корабль";
        final String TRUCK_NAME = "Грузовик";
        final String PLANE_NAME = "Самолёт";
        final float SHIP_PRICE = 30.05f;
        final float TRUCK_PRICE = 10.03f;
        final float PLANE_PRICE = 50.01f;
        //Transport transport = null;
        int speed;

        speed = city.getDistance() / hours;     // скорость с которой должен двигаться транспорт для доставки в срок
        if (speed < 40 && city.isOnWater()) newTransport = new Ship(SHIP_NAME, multipleWeight(weight), speed, SHIP_PRICE);
        if (speed > 120 && city.isHasAirport()) newTransport = new Plane(PLANE_NAME, multipleWeight(weight), speed, PLANE_PRICE);
        if (speed > 40 && speed <120) newTransport = new Truck(TRUCK_NAME, multipleWeight(weight),speed, PLANE_PRICE);


        System.out.println(newTransport.getName()+" - грузоподъёмность "+ newTransport.getCapacity()+" скорость "+ newTransport.getSpeed());
        return newTransport;
    }



    public static int multipleWeight ( int a){  // необходимая грузоподъемность
        if (Math.round(a) % 500 == 0) {         // округлять вверх  Math.floor
        } else {
            while (a % 500 != 0) {
                a -= 1;                         // найти более быстрый метод
                if (a % 500 == 0) {
                    //w = a;
                }
            }
        }
        return a;
    }




}
