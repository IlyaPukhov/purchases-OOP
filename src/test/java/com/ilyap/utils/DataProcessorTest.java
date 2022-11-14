package com.ilyap.utils;

import com.ilyap.exception.InputDataException;
import com.ilyap.purchases.AnotherPurchase;
import com.ilyap.purchases.Purchase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DataProcessorTest {

    private final List<Purchase> list = new ArrayList<>();
    private final DataProcessor<Purchase> dataProcessor = new DataProcessor<>(list);

    @BeforeEach
    void setUp() {
        for (int i = 0; i < 5; i++) {
            list.add(Mockito.mock(Purchase.class));
            Mockito.when(list.get(i).getId()).thenReturn(i);
            Mockito.when(list.get(i).getPrice()).thenReturn(5.0 * (i + 1));
        }
    }


    @DisplayName("Get purchases in range")
    @Test
    void getPurchasesInPriceRange() {
        List<AnotherPurchase> anotherPurchases = Arrays.asList(
                new AnotherPurchase(2, 15),
                new AnotherPurchase(3, 20)
        );
        assertIterableEquals(anotherPurchases, dataProcessor.getPurchasesInPriceRange(10, 25, 2));
    }

    @DisplayName("Get exception when getting purchases in range")
    @Test
    void getPurchasesInPriceRangeException() {
        Exception exception = assertThrows(
                InputDataException.class,
                () -> dataProcessor.getPurchasesInPriceRange(25, 10, 5)
        );
        assertEquals("Incorrect input data!", exception.getMessage());
    }

    @DisplayName("Get exception when getting purchases with limit")
    @Test
    void getPurchasesLimitException() {
        Exception exception = assertThrows(
                InputDataException.class,
                () -> dataProcessor.getPurchasesInPriceRange(10, 25, -5)
        );
        assertEquals("Incorrect input data!", exception.getMessage());
    }


    @DisplayName("Get purchase by price")
    @ParameterizedTest(name = "Get purchase #{index} by price correct")
    @ValueSource(ints = {0, 3, 2, 4})
    void getPurchaseByPrice(int index) {
        assertEquals(Optional.of(new AnotherPurchase(list.get(index).getId(), list.get(index).getPrice())),
                dataProcessor.getPurchaseByPrice(list.get(index).getPrice()));
    }

    @DisplayName("Get purchase by non-exist price")
    @Test
    void getPurchaseByPrice() {
        assertEquals(Optional.empty(),
                dataProcessor.getPurchaseByPrice(10_000));
    }

    @DisplayName("Get exception when getting purchase by negative price")
    @Test
    void getPurchaseByPriceException() {
        Exception exception = assertThrows(
                InputDataException.class,
                () -> dataProcessor.getPurchaseByPrice(-3)
        );
        assertEquals("Incorrect price!", exception.getMessage());
    }
}