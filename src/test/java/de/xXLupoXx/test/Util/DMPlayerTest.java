package de.xXLupoXx.test.Util;

import de.xXLupoXx.Util.DMPlayer;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class DMPlayerTest {

    @Test
    public void lockoutTest() {

        DMPlayer player1 = DMPlayer.getDMPlayer("Testi");
        DMPlayer player2 = DMPlayer.getDMPlayer("Testi2");

        assertEquals(player1.getRemainingLockout("ignore"),Integer.MIN_VALUE);

        player1.setDungenLockout("testDungeon", 30);
        player2.setDungenLockout("testDungeon", 40);
        assertEquals(player1.getRemainingLockout("testDungeon"), 30);
        assertThat(player1.getRemainingLockout("testDungeon"), is(not(player2.getRemainingLockout("testDungeon"))));

        player1.setDungenLockout("testDungeon", 90);
        assertEquals(player1.getRemainingLockout("testDungeon"),90);

    }



}
