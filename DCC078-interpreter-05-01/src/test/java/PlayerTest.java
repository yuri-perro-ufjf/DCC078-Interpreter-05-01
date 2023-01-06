import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void shouldBeCalcFullDamageWithFormula() {
        Player player = new Player();
        player.setDamageBase(100.0);
        player.setDamageBonus(5.0);

        assertEquals(550.0, player.calcFullDamage());
    }
}