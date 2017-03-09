package com.transferwise.opinta;

import org.junit.Test;

import static org.junit.Assert.*;

public class AppleHarvesterTest {
    private int[][] fullData = {
            {2, 3, 0, 1},
            {0, 0, 1, 2},
            {0, 1, 1, 1},
            {1, 1, 1, 1}
    };
    private int[][] fullDataRolled = {
            {1, 1, 2, 1},
            {1, 1, 1, 0},
            {1, 1, 0, 3},
            {1, 0, 0, 2}
    };
    private int[][] emptyData = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
    };
    private int[][] incorrectData = {
            {1, 2, 0, 1},
            {0, 0, 1, 3},
            {-1, 1, 1, 1},
            {4, 0, 1, 1}
    };
    private int[][] oneRowData = {
            {0, 1, 2, 0, 9}
    };

    @Test(expected = HarvestException.class)
    public void collectApplesFromNullOrchard() throws Exception {
        new AppleHarvester(null).collectApples();
    }

    @Test(expected = HarvestException.class)
    public void collectApplesFromNoOrchard() throws Exception {
        new AppleHarvester(new int[][]{}).collectApples();
    }

    @Test(expected = HarvestException.class)
    public void collectApplesFromOrchardWithNegativeValues() throws Exception {
        new AppleHarvester(incorrectData).collectApples();
    }


    @Test
    public void collectApplesFromOneLineOrchard() throws Exception {
        assertEquals("The outcome of AppleHarvester for one line orchard is not equal to the maximum yield of apples.",
                12, new AppleHarvester(oneRowData).collectApples());
    }

    @Test
    public void collectApplesFromOrchardWithoutApples() throws Exception {
        assertEquals("The outcome of AppleHarvester for empty orchard is not equal to the maximum yield of apples.",
                0, new AppleHarvester(emptyData).collectApples());
    }

    @Test
    public void collectApples() throws Exception {
        assertEquals("The outcome of collectApples is not equal to the maximum yield of apples.",
                8, new AppleHarvester(fullData).collectApples());
    }

    @Test
    public void collectApplesWithTokens() throws Exception {
        assertEquals("The outcome of collectApplesWithTokens is not equal to the maximum yield of apples.",
                12, new AppleHarvester(fullData).collectApplesWithTokens());
    }

    @Test
    public void collectApplesWithTokensForRolledData() throws Exception {
        assertEquals("The outcome of collectApplesWithTokens is not equal to the maximum yield of apples.",
                12, new AppleHarvester(fullDataRolled).collectApplesWithTokens());
    }
}