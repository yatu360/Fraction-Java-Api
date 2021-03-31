package fraction;



public class FractionImpl implements Fraction {

    private int numerator;
    private int denominator;


    public FractionImpl(int numerator, int denominator) {
        int checksign=1;
        if(numerator<0) {
            checksign *= -1;
            numerator *= -1;
        }
        if(denominator<0) {
            checksign *= -1;
            denominator *= -1;
        }
        if (denominator==0)  throw new ArithmeticException("divide by zero!");

        int GCD_value = GCD(numerator, denominator);
        this.numerator=(numerator*checksign)/GCD_value;
        this.denominator=denominator/GCD_value;

    }



    public FractionImpl(int wholeNumber) {



    }


    public FractionImpl(String fraction) {
        // TODO
    }

    public int GCD(int nume, int denom) {
        return denom==0 ? nume : GCD(denom, nume%denom);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction add(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction subtract(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction multiply(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction divide(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction negate() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * @inheritDoc
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction inverse() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public int compareTo(Fraction o) {
        return 0;
    }

    /**
     * @inheritDoc
     */
    @Override

    public String toString() {
        return null;
    }

    public static void main(String[] args) {
        FractionImpl test = new FractionImpl(8, 0);
        System.out.println(test.numerator+" "+ test.denominator);

    }

}



