package Dynamic.Execution.fix;

public class Americano implements ICoffee {
    @Override
    public void prepare() {
        addCoffee();
        addWater();
    }

    @Override
    public void addExtras() { }

    private void addCoffee() { }
    private void addWater() { }
}
