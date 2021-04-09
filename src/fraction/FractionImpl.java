package fraction;


import java.util.Objects;

public class FractionImpl implements Fraction {

    private int numerator;
    private int denominator;

    /**
     * Parameters are the numerator and the denominator. Normalize the fraction as you create it.
     * For instance, if the parameters are (8, -12), create a Fraction with numerator -2 and denominator 3.
     * The constructor will throw an ArithmeticException if the denominator is zero.
     */
    public FractionImpl(int numerator, int denominator)throws ArithmeticException{
        if (denominator==0)  throw new ArithmeticException("divide by zero!");
        fractionValidator(numerator, denominator);
    }

    /**
     * The parameter is the numerator and 1 is the implicit denominator.
     */
    public FractionImpl(int wholeNumber) {
        this.setNumerator(wholeNumber);
        this.setDenominator(1);
    }

    /**
     * The parameter is a String containing either a whole number, such as "5" or "-3", or a fraction, such as "8/-12".
     * Blanks are allowed around (but not within) integers; thus, "10 /-4" is accepted, but "1 0 / -4" throws a
     * NumberFormatException. The constructor will throw an ArithmeticException if the denominator is zero.
     */
    public FractionImpl(String fraction)throws ArithmeticException, NumberFormatException {
        if (!(fraction.matches("^((\s*?)(-?)[0-9]+)\s*?(/(\s*?)(-?)[0-9]+)?(\s*?)?")))
                                        throw new NumberFormatException("Malformed fraction! "+ fraction +" is not a valid fraction.");
        int x = fraction.indexOf("/");
        String StringNumerator;
        String StringDenominator;
        try{
            StringNumerator= fraction.substring(0, x).trim();
            StringDenominator = fraction.substring(x + 1).trim();
        } catch (StringIndexOutOfBoundsException e){
            StringNumerator=fraction;
            StringDenominator="1";
        }
        int a = Integer.parseInt(StringNumerator);
        int b = Integer.parseInt(StringDenominator);
        if (b == 0) throw new ArithmeticException("divide by zero!");
        fractionValidator(a, b);

    }

    /**
     * The setter private method for numerator
     */
    private void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**
     * The setter private method for denominator
     */
    private void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    /**
     * The getter private method for numerator
     */
    private int getNumerator() {
        return this.numerator;
    }

    /**
     * The getter private method for denominator
     */
    private int getDenominator() {
        return this.denominator;
    }

    /**
     * Corrects the sign and reduces the fraction.
     *
     * @param numerator the first number (numerator).
     * @param denominator the second number(denominator).
     * Corrects sign of fraction, i.e if denominator and numerator is positive, shifts the sign to the numerator.
     * If numerator is negative and denominator is also negative, ensures that the sign is cancelled off.
     * Passes to GCD to calculate the Greatest Common Divisor.
     * Sets the numerator and denominator using the setter methods.
     */
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

    /**
     * Calculates the Greatest Common Divisor for two numbers using Euclid's algorithm.  
     *
     * @param nume the first number (numerator).
     * @param denom the second number(denominator).
     * @return the Greatest Common Divisor.
     */
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


    }

}



