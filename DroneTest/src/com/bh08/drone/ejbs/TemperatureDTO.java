package com.bh08.drone.ejbs;

import java.io.Serializable;
import java.util.Objects;

public class TemperatureDTO implements Serializable {
    private Long id;
    
    private int value; 
    
    private Long DroneId;

    public TemperatureDTO(Long id, int value, Long DroneId) {
        this.id = id;
        this.value = value;
        this.DroneId = DroneId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Long getDroneId() {
        return DroneId;
    }

    public void setDroneId(Long DroneId) {
        this.DroneId = DroneId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.value) ^ (Double.doubleToLongBits(this.value) >>> 32));
        hash = 67 * hash + Objects.hashCode(this.DroneId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TemperatureDTO other = (TemperatureDTO) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TemperatureDTO{" + "id=" + id + ", value=" + value + ", DroneId=" + DroneId + '}';
    }
    
    
}
