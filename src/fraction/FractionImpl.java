package fraction;



public class FractionImpl implements Fraction {

    private int numerator;
    private int denominator;



    public FractionImpl(int numerator, int denominator) {
        if (denominator==0)  throw new ArithmeticException("divide by zero!");
        fractionValidator(numerator, denominator);
    }

    public FractionImpl(int wholeNumber) {
        this.setNumerator(wholeNumber);
        this.setDenominator(1);
    }


    public FractionImpl(String fraction) {
        int x = fraction.indexOf("/");
        String StringNumerator = fraction.substring(0, x).trim();
        String StringDenominator = fraction.substring(x+1).trim();
        int a = Integer.parseInt(StringNumerator);
        int b = Integer.parseInt(StringDenominator);
        if (b==0)  throw new ArithmeticException("divide by zero!");
        fractionValidator(a, b);

    }


    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public int getNumerator() {
        return this.numerator;
    }

    private int getDenominator() {
        return this.denominator;
    }

    private void fractionValidator (int numerator, int denominator){
        int checksign=1;
        if(numerator<0) {
            checksign *= -1;
            numerator *= -1;
        }
        if(denominator<0) {
            checksign *= -1;
            denominator *= -1;
        }

        int GCD_value = GCD(numerator, denominator);
        this.setNumerator((numerator*checksign)/GCD_value);
        this.setDenominator(denominator/GCD_value);
    }

    private int GCD(int nume, int denom) {
        return denom==0 ? nume : GCD(denom, nume%denom);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction add(Fraction f) {
        FractionImpl thatf = (FractionImpl) f;


        // a/b + c/d = (ad + bc) / bd
        return new FractionImpl(
                this.getNumerator() * thatf.getDenominator() + this.getDenominator() * thatf.getNumerator(),
                this.getDenominator() * thatf.getDenominator()
        );
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction subtract(Fraction f) {
        FractionImpl thatf = (FractionImpl) f;


        // a/b - c/d = (ad + bc) / bd
        return new FractionImpl(
                this.getNumerator() * thatf.getDenominator() - this.getDenominator() * thatf.getNumerator(),
                this.getDenominator() * thatf.getDenominator()
        );
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
        return this.getDenominator() == 1? String.valueOf(this.getNumerator())
                : this.getNumerator() + "/" + this.getDenominator();
    }

    public static void main(String[] args) {
        FractionImpl test = new FractionImpl("7/1");
        FractionImpl test2 = new FractionImpl("20/80");
        System.out.println(test.add(test2).toString());

        System.out.println(test.numerator+" "+ test.denominator);

    }

}



