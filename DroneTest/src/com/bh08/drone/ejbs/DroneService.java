package com.bh08.drone.ejbs;

import java.util.List;

public interface DroneService {

    void loginDrone(Long id);

    Long saveTemperature(TemperatureDTO temperatureDTO);

    List<TemperatureDTO> listAllBooks();
}
