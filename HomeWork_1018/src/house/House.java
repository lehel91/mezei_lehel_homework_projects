package house;

public class House {

    private static String contractorsName = "Hos Kft.";

    private double size;
    private boolean balcony;
    private int numberOfWindows;
    private String ownersName;

    public House(double size, boolean balcony, int numberOfWindows) {
        this.size = size;
        this.balcony = balcony;
        this.numberOfWindows = numberOfWindows;
        ownersName = "";
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public int getNumberOfWindows() {
        return numberOfWindows;
    }

    public void setNumberOfWindows(int numberOfWindows) {
        this.numberOfWindows = numberOfWindows;
    }

    public String getOwnersName() {
        return ownersName;
    }

    public void sellTo(String newOwner) {
        ownersName = newOwner;
    }
    
    public String getContractorsName() {
        return contractorsName;
    }
    
    public void setContractorsName(String contractor) {
        contractorsName = contractor;
    }

    @Override
    public String toString() {
        if (getOwnersName().isEmpty()) {
            return "***This house is for sale***\n" + "Size: " + getSize() + " square meter, with " + getNumberOfWindows() + 
                    " windows, with " + (isBalcony() ? "" : " no ") + "balcony\nContractor: " + getContractorsName() + "\n\n";
        } else {
            return getOwnersName() + "'s House:\n" + "Size: " + getSize() + " square meter, with " + getNumberOfWindows() + 
                    " windows, with " + (isBalcony() ? "" : " no ") + "balcony\nContractor: " + getContractorsName() + "\n\n";
        }
    }
}
