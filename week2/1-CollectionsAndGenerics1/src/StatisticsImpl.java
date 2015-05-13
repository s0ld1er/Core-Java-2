import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StatisticsImpl implements Statistics {
    List<Integer> numbers = new ArrayList<Integer>();
    Set<Integer> mode = new HashSet<Integer>();

    private int numberCount = 0;
    private int range;

    private double sumOfNumbers = 0;
    private double curMed;
    private double curMean;

    public void add(int number) {
        numbers.add(number);
        sumOfNumbers += number;
        numberCount++;

        Collections.sort(numbers);
        calculateMode();

        range = numbers.get(numberCount - 1) - numbers.get(0);
        curMean = sumOfNumbers / numberCount;

        if (numberCount % 2 != 0)
            curMed = numbers.get(numberCount / 2);
        else
            curMed = ((double) numbers.get((numberCount / 2)) + (double) numbers.get(((numberCount - 2) / 2))) / 2;
    }

    @Override
    public final double getMean() {
        return curMean;
    }

    @Override
    public final double getMedian() {
        return curMed;
    }

    @Override
    public final Set<Integer> getMode() {
        return mode;
    }

    @Override
    public final double getRange() {
        return range;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private final void calculateMode() {
        Map<Integer, Integer> visitedNumbers = new HashMap<Integer, Integer>();
        int maxSpan = 0;

        for (Integer curValue : numbers) {
            if (visitedNumbers.containsKey(curValue))
                visitedNumbers.put(curValue, visitedNumbers.get(curValue) + 1);

            else
                visitedNumbers.put(curValue, 1);

            if (visitedNumbers.get(curValue) > maxSpan) {
                maxSpan = visitedNumbers.get(curValue);
                mode.clear();
                mode.add(curValue);
            } else if (visitedNumbers.get(curValue) == maxSpan)
                mode.add(curValue);
        }

        if (mode.size() == numberCount)
            mode.clear();
    }

}
