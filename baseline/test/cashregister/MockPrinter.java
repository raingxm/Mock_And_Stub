package cashregister;

public class MockPrinter extends Printer{
    private boolean called =false;

    public void print(String printThis) {
       called = true;
    }

    public boolean hasBeenCalled() {
        return called;
    }
}
