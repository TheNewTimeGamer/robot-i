package engine.analytics;

import java.util.HashMap;

public class Analytics {
    
    public static HashMap<String, DataPoint> data = new HashMap<String, DataPoint>();

}

class DataPoint extends Number {

    private double value;
    
    public int intValue() {
        return (int) this.value;
    }

    public long longValue() {
        return (long) this.value;
    }

    public float floatValue() {
        return (float) this.value;
    }

    public double doubleValue() {
        return this.value;
    }

    public DataPoint increment() {
        this.value++;
        return this;
    }

    public DataPoint add(double value) {
        this.value += value;
        return this;
    }
    
}