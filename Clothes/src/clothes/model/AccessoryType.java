package clothes.model;

public enum AccessoryType {
    JEWELRY {
        @Override
        public String toString() {
            return "Jewelry";
        }
    },
    WATCH {
        @Override
        public String toString() {
            return "Watch";
        }
    },;
}
