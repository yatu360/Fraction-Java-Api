package fraction;


import java.util.Objects;

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


    private void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    private void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    private int getNumerator() {
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
                this.getDenominator() * thatf.getDenominator());
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction subtract(Fraction f) {
        FractionImpl thatf = (FractionImpl) f;


        // a/b - c/d = (ad - bc) / bd
        return new FractionImpl(
                this.getNumerator() * thatf.getDenominator() - this.getDenominator() * thatf.getNumerator(),
                this.getDenominator() * thatf.getDenominator());
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction multiply(Fraction f) {
        FractionImpl thatf = (FractionImpl) f;


        // (a/b) * (c/d) = (a*c)/(b*d)
        return new FractionImpl(
                this.getNumerator()*thatf.getNumerator(), this.getDenominator()*thatf.getDenominator());
    }


    /**
     * @inheritDoc
     */
    @Override
    public Fraction divide(Fraction f) {
        FractionImpl thatf = (FractionImpl) f;


        // (a/b) / (c/d) = (a*d)/(b*c)
        return new FractionImpl(
                this.getNumerator()*thatf.getDenominator(), this.getDenominator()*thatf.getNumerator());
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {
        return new FractionImpl(Math.abs(this.getNumerator()), Math.abs(this.getDenominator()));
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction negate() {
        return new FractionImpl(this.getNumerator()*-1, this.getDenominator());
    }

    /**
     * @inheritDoc
     */
    @Override
    public int hashCode() { //IntelliJ generated hashCode method
        return Objects.hash(this.getNumerator(), this.getDenominator());
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FractionImpl) {
            FractionImpl f = (FractionImpl) obj;
            return this.getNumerator() == f.getNumerator() && this.getDenominator() == f.getDenominator();
        }
        return false;
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
        return new FractionImpl(this.getDenominator(), this.getNumerator());
    }

    /**
     * @inheritDoc
     */
    @Override
    public int compareTo(Fraction o) {
        FractionImpl thato = (FractionImpl) o;
        return ((this.getNumerator()* thato.getDenominator())-(thato.getNumerator()*this.getDenominator()));
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
        FractionImpl test = new FractionImpl("7/0");
        FractionImpl test2 = new FractionImpl("20/80");
        System.out.println(test.compareTo(test2));

        System.out.println(test.numerator+" "+ test.denominator);

    }

}



