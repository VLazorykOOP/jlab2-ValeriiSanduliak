public class Money {
    private  double[] nominals = {500.0, 200.0, 100.0, 50.0, 20.0, 10.0, 5.0, 2.0, 1.0, 0.5, 0.25, 0.1, 0.05, 0.02, 0.01};
    private int[] counts = new int[nominals.length];
    public Money(double value) {
        int coins = (int) Math.round(value * 100);
        for (int i = 0; i < nominals.length; i++) {
            counts[i] = coins / (int) (nominals[i] * 100);
            coins -= counts[i] * (int) (nominals[i] * 100);
        }
    }
    public Money(int[] counts) {
        this.counts = counts;
    }
    public double getValue() {
        double sum = 0;
        for (int i = 0; i < counts.length; i++) {
            sum += counts[i] * nominals[i];
        }
        return sum;
    }
    public Money add(Money other) {
        int[] result = new int[counts.length];
        for (int i = 0; i < counts.length; i++) {
            result[i] = counts[i] + other.counts[i];
        }
        return new Money(result);
    }
    public Money subtract(Money other) {
        int[] result = new int[counts.length];
        for (int i = 0; i < counts.length; i++) {
            result[i] = counts[i] - other.counts[i];
        }
        return new Money(result);
    }
    public Money divide(Money other) {
        if(other.getValue() == 0){
            throw new ArithmeticException("Not divide zero");
        }
        else {
            int coins = (int) Math.round(getValue() / other.getValue() * 100);
            return new Money(coins/100.0);
        }

    }
    public Money divide(double divisor) {
        if(divisor == 0){
            throw new ArithmeticException("Not divide zero");
        }
        else {
            int coins = (int) Math.round(getValue() / divisor * 100);
            return new Money(coins / 100.0);
        }
    }
    public boolean lessThan(Money other) {
        return getValue() < other.getValue();
    }

    public boolean greaterThan(Money other) {
        return getValue() > other.getValue();
    }

    public boolean equals(Money other) {
        return getValue() == other.getValue();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((int)getValue()).append(" uah , ");
        int coins = (int)Math.round((getValue() - (int)getValue()) * 100);
        //if (coins < 10) sb.append("0");
        sb.append(coins+" kop");
        return sb.toString();
    }
}