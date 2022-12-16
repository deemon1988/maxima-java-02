package org.example;


public class TransportFactory {

    Transport getTransport(City city, int weight, int hours) {
        final String SHIP_NAME = "Корабль";
        final String TRUCK_NAME = "Грузовик";
        final String PLANE_NAME = "Самолёт";
        final float SHIP_PRICE = 30.05f;
        final float TRUCK_PRICE = 10.03f;
        final float PLANE_PRICE = 50.01f;

        Transport newTransport;
        int speed = city.getDistance() / hours;// скорость с которой должен двигаться транспорт для доставки в срок

        if (speed < 40 && city.isOnWater()) {
            newTransport = new Ship(SHIP_NAME, rWeight(weight), rSpeed(speed), SHIP_PRICE);
        } else if (speed > 120 && city.isHasAirport()) {
            newTransport = new Plane(PLANE_NAME, rWeight(weight), rSpeed(speed), PLANE_PRICE);
        }
        else {
            newTransport = new Truck(TRUCK_NAME, rWeight(weight),rSpeed(speed), TRUCK_PRICE);
        }

        System.out.println(newTransport.getName()+" - грузоподъёмность "+ newTransport.getCapacity()+" скорость "+ newTransport.getSpeed());
        return newTransport;
    }

    public int rSpeed(int spd){  // метод для округления скорости
        if (spd%10 ==0) return spd;
        else {
            int b= (int) (Math.ceil(spd/10.0)*10);
            return  b;
        }
    }

    public static int rWeight(int a){  // необходимая грузоподъемность
        if (a % 500 == 0) {return a;}
        else {
            int b= (int) (Math.ceil(a/500.0)*500);
            return  b;
        }
    }

}
