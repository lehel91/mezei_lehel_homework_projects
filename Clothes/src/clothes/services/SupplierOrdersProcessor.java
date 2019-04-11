package clothes.services;

import clothes.model.Importable;
import clothes.model.ProductFactory;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class SupplierOrdersProcessor<T extends Importable> {

    private List<Importable> clothesOrdered;
    private static String csvFilePath;
    private ProductFactory productFactory;

    public SupplierOrdersProcessor(String csvFilePath) {
        this.clothesOrdered = new LinkedList<>();
        this.csvFilePath = csvFilePath;
        productFactory = new ProductFactory();
    }

    public static String getCsvFilePath() {
        return csvFilePath;
    }

    public static void setCsvFilePath(String csvFilePath) {
        SupplierOrdersProcessor.csvFilePath = csvFilePath;
    }

    public void readOrderFromCSV() throws IOException {

        try (
                FileReader fr = new FileReader(csvFilePath);
                CSVReader csv = new CSVReader(fr)) {
            String[] row;
            while ((row = csv.readNext()) != null) {
                clothesOrdered.add((Importable) productFactory.getInstance(row[0]));
            }
        }
    }

    public void printElementsOrdered() {
        if (this.clothesOrdered.isEmpty()) {
            System.out.println("Currently there are no imported Clothes.");
        } else {
            System.out.println("The clothes imported from suppliers: ");
            for (int i = 1; i < clothesOrdered.size(); i++) {
                System.out.println(i + ". " + clothesOrdered.get(i));
            }
        }
    }
}
