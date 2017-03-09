package com.transferwise.opinta;

import java.util.ArrayList;
import java.util.List;

public class AppleHarvester {
    private int [][] orchard;
    private int rowCount;
    private int colCount;

    public AppleHarvester(int [][] orchard) {
        this.orchard = orchard;
    }

    public int collectApples() throws HarvestException {
        checkOrchard();

        rowCount = orchard.length;
        colCount = orchard[0].length;

        int[][] maxValues = getMaxValuesOrchard();

        return maxValues[0][maxValues[0].length-1];
    }

    public int collectApplesWithTokens() throws HarvestException {
        checkOrchard();

        rowCount = orchard.length;
        colCount = orchard[0].length;

        List<List<Integer>> allCombinations = new ArrayList<>();
        fillAllCombinations(rowCount-1, 0, allCombinations, null);
        implementTokens(allCombinations);

        return getMaxSum(allCombinations);
    }

    private int getMaxSum(List<List<Integer>> allCombinations) {
        int result = Integer.MIN_VALUE;
        for (List<Integer> combination : allCombinations) {
            int max = 0;
            for (Integer number : combination) {
                max += number;
            }
            if (max > result) {
                result = max;
            }
        }
        return result;
    }

    private void implementTokens(List<List<Integer>> allCombinations) {
        for (List<Integer> combination : allCombinations) {
            doubleTopTwo(combination);
        }
    }

    private void fillAllCombinations(int currentRow, int currentColumn,
                                     List<List<Integer>> combinations, List<Integer> currentCombination) {
        if (currentCombination == null) {
            currentCombination = new ArrayList<>(rowCount + colCount + 2);
        }
        if (currentRow == 0) {
            for (int i = currentColumn; i < colCount; i++) {
                currentCombination.add(orchard[currentRow][i]);
            }
            combinations.add(currentCombination);
            return;
        }
        if (currentColumn == colCount - 1) {
            for (int i = currentRow; i >= 0; i--) {
                currentCombination.add(orchard[i][currentColumn]);
            }
            combinations.add(currentCombination);
            return;
        }
        currentCombination.add(orchard[currentRow][currentColumn]);
        fillAllCombinations(currentRow - 1, currentColumn, combinations, new ArrayList<>(currentCombination));
        fillAllCombinations(currentRow, currentColumn + 1, combinations, new ArrayList<>(currentCombination));
    }

    private void checkOrchard() throws HarvestException {
        if (orchard == null || orchard.length == 0 || orchard[0].length == 0) {
            throw new HarvestException("Orchard can't be empty!");
        }

        int row = orchard.length;
        int column = orchard[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (orchard[i][j] < 0) {
                    throw new HarvestException("Orchard can't have negative values!");
                }
            }
        }
    }

    private int[][] getMaxValuesOrchard() {
        int[][] maxValues = new int[rowCount][colCount];
        for (int i = rowCount-1; i >= 0; i--) {
            for (int j = 0; j < colCount; j++) {
                if (i == rowCount-1 && j == 0) {
                    maxValues[i][j] = orchard[i][j];
                } else if (i == rowCount-1) {
                    maxValues[i][j] = maxValues[i][j-1] + orchard[i][j];
                } else if (j == 0) {
                    maxValues[i][j] = maxValues[i+1][j] + orchard[i][j];
                } else {
                    maxValues[i][j] = Math.max(maxValues[i][j-1], maxValues[i+1][j]) + orchard[i][j];
                }
            }
        }

        return maxValues;
    }

    private void doubleTopTwo(List<Integer> combination) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (Integer number : combination) {
            if (number > max1) {
                max2 = max1; max1 = number;
            } else if (number > max2) {
                max2 = number;
            }
        }
        combination.add(max1);
        combination.add(max2);
    }
}
