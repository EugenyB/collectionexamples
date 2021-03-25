package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void countOdds() {
        List<Integer> list = List.of(1, 3, 4, 5, 6, 7, 8, 9, 11, 12);
        int expected = 6;
        int result = main.countOdds(list);
        assertEquals(expected, result);
    }
}