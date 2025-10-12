package Score;
/**
 * @author Eran Shalev Hamdani
 * this class is a counter, it helps us decrease a number from two different classes.
 */
public class Counter {
    private int counter;

    /**
     * the builder gets an int and builds a counter.
     * @param counter "an int".
     */
    public Counter(int counter) {
        this.counter = counter;
    }

    /**
     * add number to current count.
     * @param number the number.
     */
    public void increase(int number) {
        this.counter += number;
    }
    /**
     * subtract number to current count.
     * @param number the number.
     */
    public void decrease(int number) {
        this.counter -= number;
    }

    /**
     * get current count.
     * @return "".
     */
    public int getValue() {
        return counter;
    }
}