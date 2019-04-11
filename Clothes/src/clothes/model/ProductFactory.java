package clothes.model;

import clothes.model.Accessory;
import clothes.model.AccessoryType;
import clothes.model.Coat;
import clothes.model.CoatType;
import clothes.model.Jacket;
import clothes.model.JacketType;
import clothes.model.Lingerie;
import clothes.model.LingerieType;
import clothes.model.Product;
import clothes.model.Shoe;
import clothes.model.ShoeType;

public class ProductFactory {

    public Product getInstance(String productType) {
        String type = productType.toUpperCase();
        Product product = null;
        switch (type) {
            case "JEWELRY":
                product = new Accessory(1000, AccessoryType.JEWELRY);
                break;
            case "WATCH":
                product = new Accessory(5000, AccessoryType.WATCH);
                break;
            case "RAINCOAT":
                product = new Coat(5000, CoatType.RAIN);
                break;
            case "WINTERCOAT":
                product = new Coat(7000, CoatType.WINTER);
                break;
            case "WOMENCOAT":
                product = new Coat(5500, CoatType.WOMEN);
                break;
            case "MENCOAT":
                product = new Coat(6000, CoatType.MEN);
                break;
            case "UNISEXCOAT":
                product = new Coat(6500, CoatType.UNISEX);
                break;
            case "LEATHERJACKET":
                product = new Jacket(8500, JacketType.LEATHER);
                break;
            case "FARMERJACKET":
                product = new Jacket(4500, JacketType.FARMER);
                break;
            case "MENLINGERIE":
                product = new Lingerie(800, LingerieType.ONE_PART_MEN);
                break;
            case "WOMENLINGERIE":
                product = new Lingerie(1000, LingerieType.ONE_PART_WOMEN);
                break;
            case "WOMENLINGERIE_2PARTS":
                product = new Lingerie(1500, LingerieType.TWO_PART);
                break;
            case "SPORTSHOES":
                product = new Shoe(6000, ShoeType.SPORT, false);
                break;
            case "SPORTSHOES_WP":
                product = new Shoe(7000, ShoeType.SPORT, true);
                break;
            case "URBANSHOES":
                product = new Shoe(6500, ShoeType.URBAN, false);
                break;
            case "URBANSHOES_WP":
                product = new Shoe(7500, ShoeType.URBAN, true);
                break;
            case "HIKINGSHOES":
                product = new Shoe(8000, ShoeType.HIKING, false);
                break;
            case "HIKINGSHOES_WP":
                product = new Shoe(7500, ShoeType.HIKING, true);
                break;
        }
        return product;
    }
}
