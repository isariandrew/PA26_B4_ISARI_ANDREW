public final class GasStation extends Location{
    private int gasPrice;

    public GasStation(String name, LocationType newLocation, int coordX, int coordY, int gasPrice) {
        super(name, newLocation, coordX, coordY);
        this.gasPrice = gasPrice;
    }

    public int getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(int gasPrice) {
        this.gasPrice = gasPrice;
    }
}
