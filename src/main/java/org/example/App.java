package org.example;

public class App 
{
    public static void main( String[] args )
    {

        City Spb = new City("Санкт-Петербург", 98, true, true);
        City Murmansk = new City("Мурманск",1400,true, false);
        City Tver = new City("Тверь", 540);
        //Spb.printName();
        Truck trailer_truck = new Truck("Грузовик с полуприцепом", 44, 90, 50.41358 );
        Ship tanker = new Ship("Танкер",18159000, 27, 3.82613);
        Plane aircraft = new Plane("Самолёт",120000, 800, 70.6864);
        //System.out.println("Стоимость: "+Lada.getPrice(Spb));
        //System.out.println("Стоимость: "+Bulk_Carrier.getPrice(Murmansk));
        City Mosсow = new City("Москва", 800, true, true);
        System.out.println(tanker.getPrice(Spb));
    }
}
