package com.spnikit.homework2;

import org.junit.jupiter.api.Test;

import static com.spnikit.homework2.ComplexExamples.fuzzySearch;
import static org.junit.jupiter.api.Assertions.*;

public class ComplexExamplesTest {

    @Test
    public void testFuzzySearch() {

        assertAll(() -> {
            assertTrue(fuzzySearch("car", "ca6$$#_rtwheel")); // true
            assertTrue(fuzzySearch("cwhl", "cartwheel")); // true
            assertTrue(fuzzySearch("cwhee", "cartwheel")); // true
            assertTrue(fuzzySearch("cartwheel", "cartwheel")); // true
            assertFalse(fuzzySearch("cwheeel", "cartwheel")); // false
            assertFalse(fuzzySearch("lw", "cartwheel")); // false
        });
    }
}
