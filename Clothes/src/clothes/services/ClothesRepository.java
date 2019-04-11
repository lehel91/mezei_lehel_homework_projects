package clothes.services;

import clothes.model.Product;
import clothes.model.ProductFactory;
import java.util.LinkedList;
import java.util.List;

public class ClothesRepository {

    private List<Product> products;
    private SupplierOrdersProcessor supplierOrdersProcessor;
    private ProductFactory productFactory;
    private static String currentCsvFilePath = "C:\\workspace\\Clothes\\src\\clothes\\clothes.csv";

    public ClothesRepository() {
        this.products = new LinkedList<>();
        this.supplierOrdersProcessor = new SupplierOrdersProcessor(currentCsvFilePath);
        this.productFactory = new ProductFactory();
    }

    public static String getCurrentCsvFilePath() {
        return currentCsvFilePath;
    }

    //a currentCsvFilePath setterének használatával mindig újabb SupplierOrdereket tudunk feldolgozni csv-ből
    public static void setCurrentCsvFilePath(String currentCsvFilePath) {
        ClothesRepository.currentCsvFilePath = currentCsvFilePath;
    }

    public List<Product> getProducts() {
        return products;
    }

    public SupplierOrdersProcessor getSupplierOrdersProcessor() {
        return supplierOrdersProcessor;
    }

    public void addNewProduct(String productType) {
        this.products.add(productFactory.getInstance(productType));
    }

    public void removeProduct() {
        if (!products.isEmpty()) {
            listAllProducts();
            int choice = extra.Console.readInt("Choose a product from the list to remove: ");

            while (choice < 1 || choice > products.size()) {
                choice = extra.Console.readInt("Wrong choice, you can chooce only between 1 and " + products.size());
            }
            this.products.remove(choice - 1);
        } else {
            System.out.println("There are no clothes yet!");
        }
    }

    public void listAllProducts() {
        if (this.products.isEmpty()) {
            System.out.println("Currently there are no Clothes in the shop.");
        } else {
            System.out.println("The clothes in the shop: ");
            for (int i = 0; i < products.size(); i++) {
                System.out.println(i + 1 + ". " + products.get(i));
            }
        }
    }

}
