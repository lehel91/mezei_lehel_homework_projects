package com.bh08.drone.main;

import com.bh08.drone.ejbs.DroneService;
import com.bh08.drone.ejbs.TemperatureDTO;
import com.bh08.drone.ejbs.TemperatureService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Main {

    public static void main(String[] args) {
        try {
            Context context = new InitialContext();
//            TemperatureService temperatureService = (TemperatureService) context.lookup("java:global/Drone/TemperatureBean!com.bh08.drone.ejbs.TemperatureService");
//            temperatureService.saveDrone(1L);
            
            DroneService droneService = (DroneService) context.lookup("java:global/Drone/DroneBean!com.bh08.drone.ejbs.DroneService");
            droneService.loginDrone(1L);
            droneService.saveTemperature(new TemperatureDTO(1L, 18, 1L));
        } catch (NamingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
