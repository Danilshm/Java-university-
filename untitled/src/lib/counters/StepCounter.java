package lib.counters;
public class StepCounter extends Counter {
    private int step;
    public StepCounter() {
        this.step = 1;
    }
    public StepCounter(int step) {
        this.step = step;
    }
    public int getStep() { return step; }
    public void setStep(int step) { this.step = step; }
    @Override
    public void increment() {
        setCount(getCount() + step);
    }
    @Override
    public void decrement() {
        setCount(getCount() - step);
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[count=" + getCount() + ", step=" + step + "]";
    }
}
