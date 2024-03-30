package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.lang.reflect.Method;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class MachineTest {
    @Mock
    Random mockRandom = Mockito.mock(Random.class);
    @Test
    public void testSpinWheel() throws Exception {
        Machine slotMachine = new Machine();

        when(mockRandom.nextInt(6)).thenReturn(0); // three watermelons
        slotMachine.setRandom(mockRandom);

        slotMachine.spinWheel();

        //if player gets three watermleons they should win 10 coins.
        assertEquals(55, slotMachine.getPlayer().getAmountOfCash());

    }

    @Test
    public void testWinningCombinations() throws Exception {
        Machine slotMachine = new Machine();
        Method method = Machine.class.getDeclaredMethod("winningCombinations", Symbol[].class);
        method.setAccessible(true); // Allow access to private method

        Symbol[] allSevens = {Symbol.SEVEN, Symbol.SEVEN, Symbol.SEVEN};
        assertEquals("JACKPOT!! You win 30 coins", method.invoke(slotMachine, (Object) allSevens));

        Symbol[] twoSevens = {Symbol.SEVEN, Symbol.SEVEN, Symbol.BANANA};
        assertEquals("Congrats, you got two 7's. You won 4 coins.", method.invoke(slotMachine, (Object) twoSevens));

        Symbol[] oneSeven = {Symbol.SEVEN, Symbol.BANANA, Symbol.WATERMELON};
        assertEquals("You got one 7. You won 1 coin.", method.invoke(slotMachine, (Object) oneSeven));

        Symbol[] threeSameFruit = {Symbol.BANANA, Symbol.BANANA, Symbol.BANANA};
        assertEquals("Congrats, you got three of the same fruit. You won 10 coins.", method.invoke(slotMachine, (Object) threeSameFruit));

        Symbol[] noWin = {Symbol.CHERRY, Symbol.WATERMELON, Symbol.GRAPE};
        assertEquals("Better luck next time :(", method.invoke(slotMachine, (Object) noWin));
    }
}