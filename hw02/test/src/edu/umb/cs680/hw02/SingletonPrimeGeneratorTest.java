package edu.umb.cs680.hw02;

import org.junit.jupiter.api.Test;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class SingletonPrimeGeneratorTest {
    @Test
    public void testEqualityOfTwoObjectInstances() {
        SingletonPrimeGenerator gen1 = SingletonPrimeGenerator.getInstance(2, 50);
        SingletonPrimeGenerator gen2 = SingletonPrimeGenerator.getInstance(2, 50);
        assertSame(gen1, gen2);
    }

    @Test
    public void testInvalidArguments() {
        try {
            SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance(5, -10);
            fail("Expected RuntimeException to be thrown");
        } catch (RuntimeException e) {
            assertEquals("Wrong input values: from=5 to=-10", e.getMessage());
        }
    }

    @Test
    public void checkingNotNullOfInstance() {
        SingletonPrimeGenerator gen1 = SingletonPrimeGenerator.getInstance(2, 50);
        assertNotNull(gen1);
    }

    @Test
    public void checkingPrimesFrom1to5() {
        SingletonPrimeGenerator gen1 = SingletonPrimeGenerator.getInstance(1, 5);
        gen1.generatePrimes();
        LinkedList<Long> primes = gen1.getPrimes();
        Long[] expected = {2l, 3l, 5l};
        assertArrayEquals(expected, primes.toArray());
    }
}