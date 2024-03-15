package Dynamic.Execution;

public class Barista {
    public void BrewAmericano(Americano americano){
        americano.Grind();
        americano.AddCoffee();
        americano.AddWater();
        americano.TurnOnMachine();
        americano.Wait();
        americano.Serve();
    }

    public void Brew(Cappuccino cappuccino){
        cappuccino.Grind();
        cappuccino.PressCoffee();
        cappuccino.AddWater();
        cappuccino.AddMilk();
        cappuccino.TurnOnMachine();
        cappuccino.Wait();
        cappuccino.Serve();
    }
}
