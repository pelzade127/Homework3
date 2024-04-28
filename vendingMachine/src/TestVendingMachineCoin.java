import static org.junit.Assert.*; 
import org.junit.*;

public class TestVendingMachineCoin {

    private vendingMachine VendingMachine;

    @Before
    public void setUp() {
        VendingMachine = new vendingMachine();
    }

    @Test
    public void testCoinValid() {
        VendingMachine.coin(10);
        assertEquals(10, VendingMachine.getCredit());
    }
    
    @Test
    public void testCoinValid1() {
        VendingMachine.coin(25);
        assertEquals(25, VendingMachine.getCredit()); 
    }
    
   @Test  
   public void testCoinValid2() {
        VendingMachine.coin(100);
        assertEquals(100, VendingMachine.getCredit());
   }
    @Test
    public void testCoinInvalid() {
        VendingMachine.coin(5); // Invalid coin
        assertEquals(0, VendingMachine.getCredit()); 
    }

    @Test
    public void testCoinMaxCredit() {
   
        VendingMachine.coin(25);
        VendingMachine.coin(25);
        VendingMachine.coin(10);
        VendingMachine.coin(10);
        VendingMachine.coin(10); 
        VendingMachine.coin(10); 
        VendingMachine.coin(10); 
        assertEquals(90, VendingMachine.getCredit()); // Should cap at 90 cents
    }
    
    @Test
    public void testCoinInvalidCoins() {
        VendingMachine.coin(1); 
        VendingMachine.coin(50); 
        assertEquals(0, VendingMachine.getCredit()); 
    }


}
