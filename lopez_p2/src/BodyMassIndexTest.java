import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BodyMassIndexTest {


    @Test
    void getBMI() {
        BodyMassIndex c = new BodyMassIndex(70, 200);
        assertEquals(28.693877551020407, c.getBMI());
    }
    
    @Test
    void categorize() {
        BodyMassIndex a = new BodyMassIndex(70, 100);
        a.categorize();

        BodyMassIndex b = new BodyMassIndex(70, 150);
        b.categorize();

        BodyMassIndex c = new BodyMassIndex(70, 200);
        c.categorize();

        BodyMassIndex d = new BodyMassIndex(70, 300);
        d.categorize();
    }
    
}
