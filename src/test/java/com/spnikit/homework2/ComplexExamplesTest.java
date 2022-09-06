package com.spnikit.homework2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.spnikit.homework2.ComplexExamples.*;

public class ComplexExamplesTest {

    @Test
    public void testFuzzySearch(){
        Assertions.assertTrue(fuzzySearch("car", "ca6$$#_rtwheel")); // true
        Assertions.assertTrue(fuzzySearch("cwhl", "cartwheel")); // true
        Assertions.assertTrue(fuzzySearch("cwhee", "cartwheel")); // true
        Assertions.assertTrue(fuzzySearch("cartwheel", "cartwheel")); // true
        Assertions.assertFalse(fuzzySearch("cwheeel", "cartwheel")); // false
        Assertions.assertFalse(fuzzySearch("lw", "cartwheel")); // false
    }
}
