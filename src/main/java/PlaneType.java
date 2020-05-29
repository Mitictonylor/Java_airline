public enum PlaneType {
    BOEING(300,5000),
    CONCORDE(200, 3000),
    SMALLJET(1,1000),
    SUPERJET(800, 10000);

    private final int totalWeight;
    private final int capacity;

    PlaneType(int capacity, int totalWeight){
        this.capacity= capacity;
        this.totalWeight = totalWeight;
    }

    public int getTotalWeight() {
        return this.totalWeight;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
