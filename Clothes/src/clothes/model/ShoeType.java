package clothes.model;

public enum ShoeType {
    URBAN {
        @Override
        public String toString() {
            return "Urban shoes";
        }
    },
    HIKING {
        @Override
        public String toString() {
            return "Hiking shoes";
        }
    },
    SPORT {
        @Override
        public String toString() {
            return "Sport shoes";
        }
    };
}
