package rpg_tests;

import org.junit.Assert;
import org.junit.Test;
import rpg_lab.*;

public class HeroTests {

    @Test
    public void testHeroGainsXPWhenTargetIsDead() {

        Weapon fakeWeapon = new Weapon() {
            @Override
            public void attack(Target target) {

            }

            @Override
            public int getAttackPoints() {
                return 10;
            }

            @Override
            public int getDurabilityPoints() {
                return 0;
            }
        };

        Target fakeTarget = new Target() {
            @Override
            public int getHealth() {
                return 0;
            }

            @Override
            public void takeAttack(int attackPoints) {

            }

            @Override
            public int giveExperience() {
                return 50;
            }

            @Override
            public boolean isDead() {
                return true;
            }
        };

        Hero hero = new Hero("Misho", fakeWeapon);

        hero.attack(fakeTarget);

        Assert.assertEquals(50, hero.getExperience(), 0);

    }


}
