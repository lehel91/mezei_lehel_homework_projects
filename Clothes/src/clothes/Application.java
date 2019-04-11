package clothes;

import clothes.services.ClothesRepository;
import clothes.view.View;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Application {

    public static void main(String[] args) {

        ClothesRepository clothesRepository = new ClothesRepository();
        View view = new View(clothesRepository);

        System.out.println("***TESTING THE ADDITION OF CLOTHES***\n");
        try {
            clothesRepository.getSupplierOrdersProcessor().readOrderFromCSV();

            clothesRepository.addNewProduct("jewelry");
            clothesRepository.addNewProduct("watch");
            clothesRepository.addNewProduct("farmerjacket");
            clothesRepository.addNewProduct("jewelry");
            clothesRepository.addNewProduct("WINTERCOAT");
            clothesRepository.addNewProduct("leatherjacket");
            clothesRepository.addNewProduct("farmerjacket");
            clothesRepository.addNewProduct("hikingshoes_wp");
            clothesRepository.addNewProduct("jewelry");
            clothesRepository.addNewProduct("menlingerie");
            clothesRepository.addNewProduct("urbanshoes");
            clothesRepository.addNewProduct("MENCOAT");
            clothesRepository.addNewProduct("sportshoes");
        } catch (IOException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("\n***TESTING THE PRINT OF IMPORTED CLOTHES***\n");
        view.printAllImportedClothes();
        System.out.println("\n***TESTING THE PRINT OF CLOTHES MADE BY THE COMPANY***\n");
        view.printAllClothes();
        System.out.println("\n***TESTING THE ADDITION OF CLOTHES***\n");
        clothesRepository.addNewProduct("watch");
        System.out.println("\n***TESTING THE REMOVAL OF CLOTHES***\n");
        clothesRepository.removeProduct();
        System.out.println("");
        view.printAllClothes();
    }

}
