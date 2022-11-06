package org.example;

public class Logistics implements Repairable{
    Transport[] vehicles = new Transport[4];
    public Logistics(Transport... vehicles) {
        this.vehicles = vehicles;
    }

    public Transport[] getVehicles() {
        return vehicles;
    }

    public void setVehicles(Transport[] vehicles) {
        this.vehicles = vehicles;
    }

    String isRepairing = "";
    Transport getVehicle;

    public Transport getShipping(City city, int weight, int time) {
        double spentTime;
        float stoimost;
        float minPrice ;
        //Transport getVehicle = vehicles[0];


        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i]instanceof Ship ) {
                //System.out.println("Водный транспорт");
            }
            minPrice = vehicles[i].getPrice(city); //мин. стоимость для водного если нет реки
            spentTime = (double)city.getDistance()/vehicles[i].getSpeed();
            stoimost = (float) vehicles[i].getCostOfKm() * city.getDistance();


            boolean capacity = false;
            boolean sTime = false;
            if (spentTime<time) sTime = true;
            if (vehicles[i].getCapacity()>weight) capacity = true;

            float counter = stoimost;
            if (sTime == true && capacity == true && minPrice > counter) {    // вынести в отдельный метод
                minPrice = counter;
                getVehicle = vehicles[i];
            }
            else {
                getVehicle = vehicles[i];
                if (isShippingAvaible()==true)  getVehicle = vehicles[i];    // в методе isShippingAvaible() проверять если
                //else { getVehicle = null;}
                //return vehicles[i];
                // водный транспорт и нет реки
            }
        }
        System.out.println();
        System.out.println(getVehicle.getName()+" "+getVehicle.getPrice(city));
        return getVehicle;
    }


    private boolean isShippingAvaible () {
        boolean isAvaible = false;
        if(isRepairing())
        {
            System.out.println("Не Доступен");
            // выбирать транспорт заново исключая недоступный транспорт
            isAvaible = false;

        }
        else
        {
            System.out.println("Доступен");
            isAvaible = true;

        }

        return isAvaible;
    }

    @Override
    public void startRepair() {
        String[] repair = {"Танкер","Грузовик с полуприцепом",""};
        String[] isRepair = new String[repair.length];
        String isTransport = "";
        for (int i=0; i< repair.length; i++)
        {
            if (repair[i] != null) isRepair[i] = repair[i];
            if(isRepair[i] == getVehicle.getName()) isTransport = getVehicle.getName();
        }
        isRepairing = isTransport;
    }

    @Override
    public void finishRepair() {

    }

    @Override
    public boolean isRepairing() {
        boolean repairValue = false;
        startRepair();
        if(isRepairing == getVehicle.getName()) { repairValue = true;} //на ремонте

        return repairValue;
    }

}




