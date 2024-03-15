package Dynamic.Execution.fix;

public class Cappucino implements ICoffee{
    @Override
    public void prepare() {
        pressCoffee();
        addWater();
        addMilk();
    }

    @Override
    public void addExtras() {
        makeCinnamonPrint();
    }

    private void pressCoffee() { }
    private void addWater() { }
    private void addMilk() { }
    private void makeCinnamonPrint() { }
}
