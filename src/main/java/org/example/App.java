package org.example;

public class App 
{
    public static void main( String[] args )
    {
        City Spb = new City("Санкт-Петербург", 88);
        Spb.printName();
        Transport Lada = new Transport("Лада Гранта", 920, 60,3.82613 );
        System.out.println("Стоимость: "+Lada.getPrice(Spb));
    }
}
