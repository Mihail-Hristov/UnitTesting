package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class DummyTest {
    private static final int DUMMY_HEALTH = 100;
    private static final int DUMMY_XP = 10;
    private static final int ATTACK_POINTS = 80;
    private static final int DELTA = 0;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void initializeObject() {
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);

    }

    @Test
    public void testDummyLosesHealthIfAttack() {
        this.dummy.takeAttack(ATTACK_POINTS);
        Assert.assertEquals(20, dummy.getHealth(), DELTA);
    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyThrowsExceptionIfAttack() {
        dummy.takeAttack(ATTACK_POINTS);
        dummy.takeAttack(ATTACK_POINTS);
        dummy.takeAttack(ATTACK_POINTS);
    }

    @Test
    public void testDeadDummyCanGiveXP() {
        dummy.takeAttack(ATTACK_POINTS);
        dummy.takeAttack(ATTACK_POINTS);
        Assert.assertEquals(DUMMY_XP, dummy.giveExperience(), DELTA);
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyCanNotGiveXP() {
        dummy.takeAttack(ATTACK_POINTS);
        Assert.assertEquals(40, dummy.giveExperience(), DELTA);
    }

}
