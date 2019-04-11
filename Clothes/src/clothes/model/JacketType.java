package clothes.model;

public enum JacketType {
    LEATHER {
        @Override
        public String toString() {
            return "Leather Jacket";
        }
    },
    FARMER {
        @Override
        public String toString() {
            return "Farmer Jacket";
        }
    };
}
