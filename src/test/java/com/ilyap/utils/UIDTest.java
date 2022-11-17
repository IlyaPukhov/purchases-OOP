package com.ilyap.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UIDTest {

    @BeforeEach
    void setUp() {
        UID.reset();
        for (int i = 0; i < 5; i++) {
            UID.getNextId();
        }
    }

    @DisplayName("Correct get next id")
    @Test
    void getNextId() {
        assertEquals(5, UID.getNextId());
    }

    @DisplayName("Correct reset id")
    @Test
    void reset() {
        UID.reset();
        assertEquals(0, UID.getNextId());
    }
}