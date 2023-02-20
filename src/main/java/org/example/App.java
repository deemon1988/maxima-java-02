package org.example;

public class App {
    public static void main(String[] args) {
        City Spb = new City("Санкт-Петербург", 120, true, true);
        City Murmansk = new City("Мурманск", 1400, false, true);
        City Tver = new City("Тверь", 540, false, true);
        City myCity = new City("Город", 540);
        City Mosсow = new City("Москва", 800, true, true);

        Truck trailerTruck = new Truck("Грузовик с полуприцепом", 24000, 120, 150.41);
        Truck roadTrain = new Truck("Автопоезд", 44000, 100, 180.41);
        Ship tanker = new Ship("Танкер", 18159000, 27, 300.82);
        Plane aircraft = new Plane("Самолёт", 120000, 800, 600.68);
        Ship kater = new Ship("Катер", 1815, 90, 100.82);


        Logistics logistics = new Logistics(tanker, roadTrain, kater, aircraft, trailerTruck);
        logistics.getShipping(Mosсow, 1900, 8);


        System.out.println();

        TransportFactory factory = new TransportFactory();
        Transport transport = factory.getTransport(Murmansk, 190700, 1);


    }

}