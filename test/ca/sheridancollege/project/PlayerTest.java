package ca.sheridancollege.project;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlayerTest {

    @Test
    public void testGetHasInsurance() {
        Player player = new Player();
        boolean expected = false;
        assertEquals(expected, player.getHasInsurance());
    }
}
