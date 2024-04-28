import static org.junit.Assert.*; 
import org.junit.*;

public class TestVendingMachineGetChoc {

    private vendingMachine VendingMachine;

    @Before
    public void setUp() {
        VendingMachine = new vendingMachine();
        VendingMachine.addChoc("c1");
        VendingMachine.addChoc("c2");
        VendingMachine.addChoc("c3");
        VendingMachine.addChoc("c4");
    }

    @Test
    public void testGetChocEnoughCredit() {
        VendingMachine.coin(100); 
        StringBuffer choc = new StringBuffer("c1");
        int change = VendingMachine.getChoc(choc);
        assertEquals("c1", choc.toString()); 
        assertEquals(10, change); 
    }

    @Test
    public void testGetChocWithoutEnoughCredit() {
        StringBuffer choc = new StringBuffer("c1");
        int change = VendingMachine.getChoc(choc);
        assertEquals("", choc.toString()); 
        assertEquals(0, change); 
    }

    @Test
    public void testGetChocInvalidChocType() {
        VendingMachine.coin(100); 
        StringBuffer choc = new StringBuffer("c4"); 
        int change = VendingMachine.getChoc(choc);
        assertEquals("", choc.toString()); 
        assertEquals(100, change); 
    }
    
    @Test
    public void testGetChocEmptyStock() {
        StringBuffer choc = new StringBuffer("c1");
        int change = VendingMachine.getChoc(choc);
        assertEquals("", choc.toString()); 
        assertEquals(0, change); 
        
    }
    
    @Test
    public void testGetChocNonExistingType() {
        // Add some credit
        VendingMachine.coin(100);
        StringBuffer choc = new StringBuffer("c4"); 
        int change = VendingMachine.getChoc(choc);
        assertEquals("", choc.toString());
        assertEquals(100, change); 
    }
    
    @Test
    public void testGetChocInsufficientCredit() {
        VendingMachine.coin(25);
        StringBuffer choc = new StringBuffer("c1");
        int change = VendingMachine.getChoc(choc);
        assertEquals("", choc.toString());
        assertEquals(25, change); 
    }

 
}
