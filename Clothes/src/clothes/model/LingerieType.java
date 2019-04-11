package clothes.model;

public enum LingerieType {
    ONE_PART_MEN {
        @Override
        public String toString() {
            return "Lingerie for men";
        }
    },
    ONE_PART_WOMEN {
        @Override
        public String toString() {
            return "One-part lingerie for women";
        }
    },
    TWO_PART {
        @Override
        public String toString() {
            return "Two-parts lingerie for women";
        }
    };

}
