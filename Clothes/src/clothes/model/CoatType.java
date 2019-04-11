package clothes.model;

public enum CoatType {
    RAIN {
        @Override
        public String toString() {
            return "Raincoat";
        }
    },
    WINTER {
        @Override
        public String toString() {
            return "Wintercoat";
        }
    },
    WOMEN {
        @Override
        public String toString() {
            return "Coat for women";
        }
    },
    MEN {
        @Override
        public String toString() {
            return "Coat for men";
        }
    },
    UNISEX {
        @Override
        public String toString() {
            return "Unisex coat";
        }
    };
}
