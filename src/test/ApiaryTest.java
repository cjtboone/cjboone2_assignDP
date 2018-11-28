package test;

import static org.junit.Assert.assertNotNull;

import main.Apiary;

import org.junit.Test;

public class ApiaryTest {

    @Test
    public void test() {
        Apiary.setMapSize(30, 50);
        Apiary apiary = Apiary.getApiary();
        assertNotNull(apiary);
        
        int ticks = 10;
        while (ticks > 0) {
            apiary.buzz();
            assertNotNull(apiary);
            ticks--;
        }
        
        assertNotNull(Apiary.getApiaryMap());
        assertNotNull(Apiary.getApiaryMap().getHives());
    }

}
