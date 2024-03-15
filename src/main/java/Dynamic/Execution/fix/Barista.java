package Dynamic.Execution.fix;

public class Barista {
    public void Brew(ICoffee coffee){
        grind();
        coffee.prepare();
        turnOnMachine();
        waitProcess();
        coffee.addExtras();
        serve();
    }

    private void grind() { }
    private void turnOnMachine() { }
    private void waitProcess() { }
    private void serve() { }
}
