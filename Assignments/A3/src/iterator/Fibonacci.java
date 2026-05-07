package iterator;

public class Fibonacci implements MyIterator {
    private int upperBound;
    private int previousNumber;
    private int currentNumber;

    public Fibonacci(int upperBound) {
        this.upperBound = upperBound;
        currentNumber = 1;
        previousNumber = 0;
    }

    @Override
    public boolean hasNext() {
        return currentNumber <= upperBound;
    }

    @Override
    public int next() {
        if (!hasNext())
            return previousNumber;

        int temp = currentNumber;
        currentNumber = previousNumber + currentNumber;
        previousNumber = temp;
        
        return previousNumber;
    }
}
