package org.example;

public class Logistics implements Repairable{
    Transport[] vehicles;
    public Logistics(Transport... vehicles) {
        this.vehicles = vehicles;
    }

    public Transport[] getVehicles() {
        return vehicles;
    }

    public void setVehicles(Transport[] vehicles) {
        this.vehicles = vehicles;
    }

    String getIsRepairing = "";
    Transport getVehicle;
    Transport getTransport;



    public Transport getShipping(City city, int weight, int time) throws Exception{
        float stoimost=0;
        float minPrice=0 ;
        getVehicle = vehicles[0];
        float[] getPrices;
        getPrices = new float[vehicles.length];

        for (int i = 0; i < vehicles.length; i++) {
            double spentTime=0;
            int itCapacity=0;
            boolean capacity = false;
            boolean sTime = false;

            getVehicle = vehicles[i];
            if (isShippingAvailable()) {
                stoimost = vehicles[i].getPrice(city);
                getPrices[i]=stoimost;      // массив стоимости доставки
            }
            if (stoimost!=0) {                          // почистить код, нужно ли условие  if (stoimost!=0) ?
                spentTime = (double)city.getDistance()/vehicles[i].getSpeed();
                itCapacity = vehicles[i].getCapacity();
                if (spentTime!=0 && spentTime<time) sTime = true;
                if (itCapacity>weight) capacity = true;
            }
            System.out.println(vehicles[i].getName()+" "+Math.round(spentTime)+" - "+Math.round(stoimost));
            if(sTime==true && capacity==true) {  if(stoimost!=0 && minPrice==0)minPrice = stoimost;}
            if (sTime == true && capacity == true  && stoimost <= minPrice ) {
                getTransport = vehicles[i];
                minPrice = stoimost;
            }
        }
        System.out.println();
        if (getTransport==null){
            throw new LogisticsGetShippingException("Нет нужного транспорта");
        }
        System.out.println(getTransport.getName()+" "+getTransport.getPrice(city));

        return getTransport;
    }


    private boolean isShippingAvailable() {
        boolean isAvailable;
        if(isRepairing())
        {
            // System.out.println("Не Доступен");
            isAvailable = false;
        }
        else
        {
            // System.out.println("Доступен");
            isAvailable = true;
        }
        return isAvailable;
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
        getIsRepairing = isTransport; // если несколько на ремонте куда записываются ?
    }

    @Override
    public void finishRepair() {

    }

    @Override
    public boolean isRepairing() {
        boolean repairValue ;
        startRepair();
        if(getIsRepairing == getVehicle.getName()) { repairValue = true;} //на ремонте
        else repairValue = false;

        return repairValue;
    }

}




