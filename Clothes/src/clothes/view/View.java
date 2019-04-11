package clothes.view;

import clothes.services.ClothesRepository;

public class View {

    private ClothesRepository clothesRepository;

    public View(ClothesRepository clothesRepository) {
        this.clothesRepository = clothesRepository;
        
    }

    public ClothesRepository getClothesRepository() {
        return clothesRepository;
    }
    
    public void printAllClothes() {
        this.clothesRepository.listAllProducts();
    }
    
    public void printAllImportedClothes() {
        this.clothesRepository.getSupplierOrdersProcessor().printElementsOrdered();
    }

}
