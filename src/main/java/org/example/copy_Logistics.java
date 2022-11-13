package org.example;

public class copy_Logistics implements Repairable{
    Transport[] vehicles = new Transport[4];
    public copy_Logistics(Transport... vehicles) {
        this.vehicles = vehicles;
    }

    public Transport[] getVehicles() {
        return vehicles;
    }

    public void setVehicles(Transport[] vehicles) {
        this.vehicles = vehicles;
    }

    String getIsRepairing = ""; // переиминовать в getIsRepairing
    Transport getVehicle;
    Transport getTransport;



    public Transport getShipping(City city, int weight, int time) {
        float stoimost=0;
        float minPrice=0 ;
        getVehicle = vehicles[0];
       // minPrice = vehicles[0].getPrice(city);
        float[] getPrices;
        getPrices = new float[vehicles.length];
       // minPrice = vehicles[0].getPrice(city);

        for (int i = 0; i < vehicles.length; i++) {
            double spentTime=0;
            int itCapacity=0;
            boolean capacity = false;
            boolean sTime = false;


            getVehicle = vehicles[i];
            if (isShippingAvaible()==true ) {

                stoimost = vehicles[i].getPrice(city);
               // if(stoimost!=0 && minPrice==0)minPrice = stoimost;
               // if(stoimost!=0 && minPrice>stoimost)minPrice = stoimost;
                getPrices[i]=stoimost;      // массив стоимости доставки

            }
            if (stoimost!=0) {                          // почистить код, нужно ли условие  if (stoimost!=0) ?
                spentTime = (double)city.getDistance()/vehicles[i].getSpeed();
                itCapacity = vehicles[i].getCapacity();
                if (spentTime!=0 && spentTime<time) sTime = true;
                //else { minPrice=0;}
                if (itCapacity>weight) capacity = true;
               // else {minPrice=0;}
                  //  if ( minPrice > stoimost && minPrice !=0) minPrice = stoimost;

                }

            System.out.println(vehicles[i].getName()+" "+spentTime+" "+stoimost);
            if(sTime==true && capacity==true) {  if(stoimost!=0 && minPrice==0)minPrice = stoimost;}
            if (sTime == true && capacity == true  && stoimost <= minPrice ) {  //&& stoimost <= minPrice
                getTransport = vehicles[i];
                minPrice = stoimost;// minPrice = stoimost
            }
           // else { minPrice=0;}

        }
        System.out.println();
        System.out.println(getTransport.getName()+" "+getTransport.getPrice(city));
        return getTransport;
    }


    private boolean isShippingAvaible () {
        boolean isAvaible = false;
        if(isRepairing())
        {
            // System.out.println("Не Доступен");
            isAvaible = false;
        }
        else
        {
            // System.out.println("Доступен");
            isAvaible = true;
        }
        return isAvaible;
    }

    @Override
    public void startRepair() {
        String[] repair = {"Танкер"};
        String[] isRepair = new String[repair.length];
        String isTransport = "";
        for (int i=0; i< repair.length; i++)
        {
            if (repair[i] != null) isRepair[i] = repair[i];
            if(isRepair[i] == getVehicle.getName()) isTransport = getVehicle.getName(); // getIsRepairing = getVehicle.getName()
        }
        getIsRepairing = isTransport; // не нужно
    }

    @Override
    public void finishRepair() {

    }

    @Override
    public boolean isRepairing() {
        boolean repairValue = false;
        startRepair();
        if(getIsRepairing == getVehicle.getName()) { repairValue = true;} //на ремонте

        return repairValue;
    }

}




