// 313309114.

/**
 * A class that count things that help us to do some action and information.
 */
public class Counter {
    private int count;

    /**
     * constructor.
     * @param number is the number that the counter start with.
     */
    public Counter(int number) {
        this.count = number;
    }

    /**
     * add number to current count.
     * @param number the number that we want to add to the current number.
     */
    public void increase(int number) {
        this.count = this.count + number;
    }

    /**
     * subtract number from current count.
     * @param number the number that we want to decrease from the current number.
     */
    public void decrease(int number) {
        this.count = this.count - number;
    }

    /**
     * get the current value of the counter.
     * @return the current value.
     */
    public int getValue() {
        return this.count;
    }
}