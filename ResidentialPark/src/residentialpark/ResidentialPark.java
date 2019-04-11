
package residentialpark;

import house.House;


public class ResidentialPark {
    private String nameOfResidentialPark; 
    private House house1, house2, house3; 
    
    public ResidentialPark(String nameOfResidentialPark, House house1, House house2, House house3) {
        this.nameOfResidentialPark = nameOfResidentialPark;
        this.house1 = house1;
        this.house2 = house2;
        this.house3 = house3;   
    }
    
    public String getNameOfResidentialPark() {
        return nameOfResidentialPark;
    }
    
    public void setNameOfResidentialPark(String nameOfTheResidentialPark) {
        this.nameOfResidentialPark = nameOfTheResidentialPark;
    }
    
    public House getHouse1() {
        return house1;
    }
    
    public void setHouse1(House house1) {
        this.house1 = house1; 
    }
    
    public House getHouse2() {
        return house2;
    }
    
    public void setHouse2(House house2) {
        this.house2 = house2; 
    }
    
    public House getHouse3() {
        return house3;
    }
    
    public void setHouse3(House house3) {
        this.house3 = house3; 
    }
    
    @Override
    public String toString() {
        return "*****" + getNameOfResidentialPark() + "*****\n" + house1 + house2 + house3;
    }
}
