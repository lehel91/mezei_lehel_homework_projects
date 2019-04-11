package clothes.model;

import java.util.Objects;

public class Shoe extends Product {

    private boolean waterProof;
    private ShoeType type;

    public Shoe(Integer price, ShoeType type, boolean waterproof) {
        super(price);
        this.type = type;
        this.waterProof = waterproof;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.waterProof ? 1 : 0);
        hash = 37 * hash + Objects.hashCode(this.type);
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
        final Shoe other = (Shoe) obj;
        if (this.waterProof != other.waterProof) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return type + ((waterProof) ? " : Waterproof" : "");
    }

}
