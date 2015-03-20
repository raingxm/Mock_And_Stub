package cashregister;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class CashRegisterTest {

    @Test
    public void shouldPrintInformation() {
        MockPrinter mockPrinter=new MockPrinter();
        CashRegister cashRegister = new CashRegister(mockPrinter);
        cashRegister.process(new Purchase(new Item[]{}));
        assertThat(mockPrinter.hasBeenCalled(), is(true));

    }

    @Test
    public void shouldDosntTestPurchaseMethod() {
        MockPurchase purchase = new MockPurchase(new Item[]{});
        CashRegister cashRegister = new CashRegister(new MockPrinter());
        cashRegister.process(purchase);
        assertThat(purchase.isInAsString,is("Real purchase asString not called."));
    }

    @Test
    public void shouldPrintInformationUseMockito() {
        Printer printer = mock(Printer.class);
        Purchase purchase = mock(Purchase.class);
        CashRegister cashRegister = new CashRegister(printer);
        cashRegister.process(purchase);
        verify(printer, times(1)).print(anyString());
    }

    @Test
    public void shouldCallPurchaseAsStringMethod() {
        Printer printer = mock(Printer.class);
        Purchase purchase = mock(Purchase.class);
        CashRegister cashRegister = new CashRegister(printer);
        cashRegister.process(purchase);
        verify(purchase).asString();
    }
}