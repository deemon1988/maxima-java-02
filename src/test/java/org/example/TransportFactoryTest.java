package org.example;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransportFactoryTest {
    private TransportFactory transportFactory;
    private City Spb;

    @Before
    public void createFactory() {
        transportFactory = new TransportFactory();
        Spb = new City("Санкт-Петербург", 120, true, true);
    }

    @Test
    public void getTransport() {
        Transport transport = transportFactory.getTransport(Spb, 190700, 4);
        assertEquals("Корабль", transport.getName());
    }

    @Test
    public void roundSpeed() {
        int result = transportFactory.roundSpeed (61);
        assertEquals(70, result);
    }

    @Test
    public void roundWeight() {
        int result = transportFactory.roundWeight(1501);
        assertEquals(2000, result);
    }

    /**
     * тесты на основе условий задачи 4 ( второго модуля)
     */

}
