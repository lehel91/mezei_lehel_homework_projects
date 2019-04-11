package main;

import house.House;
import residentialpark.ResidentialPark;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        House house1 = new House(50, true, 6);
        House house2 = new House(85, true, 10);
        House house3 = new House(45, false, 5); 
        house2.setContractorsName("Lorincz es Tarsa Kft.");
        
        System.out.println("The characteristics of the first House:\n" + house1.getSize() + " sq meters, with " + 
                house1.getNumberOfWindows() + " windows, with" + (house1.isBalcony() ? " " : " no ") + "balcony\n");

        house2.sellTo("Kis Geza");
        System.out.println("The owner of the second house is: " + house2.getOwnersName());
        System.out.println(house2);
        
        ResidentialPark losPollosHermanos = new ResidentialPark("Los Pollos Hermanos", house1, house2, house3);
        System.out.println(losPollosHermanos);
                        
    }
}
