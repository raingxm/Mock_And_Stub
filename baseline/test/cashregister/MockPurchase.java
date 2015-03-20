package cashregister;

public class MockPurchase extends Purchase {
    public String isInAsString="";

    public MockPurchase(Item[] items) {
        super(items);
    }

    public String asString(){
        isInAsString="Real purchase asString not called.";
        return isInAsString;
    }
}
