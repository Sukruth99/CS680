package edu.umb.cs680.hw01;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class PrimeGeneratorTest {

    @Test
    public void testingIfErrorWhenInputFrom2to2() {
        try {
            PrimeGenerator gen = new PrimeGenerator(2, 2);
            gen.generatePrimes();
            LinkedList<Long> primes = gen.getPrimes();
            fail();
        } catch (RuntimeException e) {
            assertEquals("Wrong input values: from=2 to=2", e.getMessage());
        }
    }

    @Test
    public void checkingPrimesFrom1to5() {

        PrimeGenerator gen = new PrimeGenerator(1, 5);
        gen.generatePrimes();
        LinkedList<Long> primes = gen.getPrimes();
        Long[] expected = {2l, 3l, 5l};
        assertArrayEquals(expected, primes.toArray());

    }

}