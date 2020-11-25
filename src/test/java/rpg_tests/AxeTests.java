package rpg_tests;

import org.junit.Assert;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class AxeTests {

    @Test
    public void testWeaponDurabilityAfterEachAttack() {
        Axe axe = new Axe(50, 50);
        Dummy dummy = new Dummy(100, 40);
        axe.attack(dummy);
        Assert.assertEquals(49, axe.getDurabilityPoints(), 0);
    }

    @Test(expected = IllegalStateException.class)
    public void testBrokenWeaponCanAttack() {
        Axe axe = new Axe(50, 1);
        Dummy dummy = new Dummy(30, 30);
        axe.attack(dummy);
        axe.attack(dummy);


    }
}
