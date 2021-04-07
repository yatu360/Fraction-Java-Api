package fraction;

import org.junit.Test;
import org.junit.Assert.*;
import org.junit.*;



public class FractionImplTest {

    @Test
    public void add() {
        String[][] testaddArray  = {{"2/1", "1/1", "1/1"},
                                    {"1/2", "1/4", "1/4"},
                                    {"79/180", "11/20", "9/-81"},
                                    {"-1/4", "-50/75", "5/12"},
                {}
        };
        for (String[] testadd: testaddArray) {
            Assert.assertEquals(new FractionImpl(testadd[0]), new FractionImpl(testadd[1]).add(new FractionImpl(testadd[2])));
        }
    }

    @Test
    public void subtract() {
    }

    @Test
    public void multiply() {
    }

    @Test
    public void divide() {
    }

    @Test
    public void abs() {
    }

    @Test
    public void negate() {
    }

    @Test
    public void testHashCode() {
    }

    @Test
    public void testEquals() {
    }

    @Test
    public void testClone() {
    }

    @Test
    public void inverse() {
    }

    @Test
    public void compareTo() {
    }

    @Test
    public void testToString() {
    }

    @Test
    public void main() {
    }
}