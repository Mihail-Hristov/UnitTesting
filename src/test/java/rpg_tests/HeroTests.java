package rpg_tests;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.*;

public class HeroTests {

    @Test
    public void testHeroGainsXPWhenTargetIsDead() {

        Weapon weaponMock = Mockito.mock(Weapon.class);
        Target targetMock = Mockito.mock(Target.class);

        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(50);

        Hero hero = new Hero("Misho", weaponMock);
        hero.attack(targetMock);
        Assert.assertEquals(50, hero.getExperience(), 0);

    }


}
