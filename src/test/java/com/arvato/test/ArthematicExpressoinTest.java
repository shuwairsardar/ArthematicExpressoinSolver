package com.arvato.test;

import com.arvato.ArthematicExpressoinSolver;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArthematicExpressoinTest {

    @Test
    public void additionTest() {
        ArthematicExpressoinSolver expressoin = new ArthematicExpressoinSolver();
        assertEquals(expressoin.solve("10+3+2+1"), "16");
    }

    @Test
    public void subtarctionTest() {
        ArthematicExpressoinSolver expressoin = new ArthematicExpressoinSolver();
        assertEquals(expressoin.solve("10-3-2-1"), "4");
    }

    @Test
    public void multiplationTest() {
        ArthematicExpressoinSolver expressoin = new ArthematicExpressoinSolver();
        assertEquals(expressoin.solve("10*3*2*1"), "60");
    }

    @Test
    public void divisionTest() {
        ArthematicExpressoinSolver expressoin = new ArthematicExpressoinSolver();
        assertEquals(expressoin.solve("10/3/2/1"), "1.6666666666666667");
    }

    @Test
    public void powTest() {
        ArthematicExpressoinSolver expressoin = new ArthematicExpressoinSolver();
        assertEquals(expressoin.solve("10^3^2^1"), "1000000");
    }

    @Test
    public void bracketTest() {
        ArthematicExpressoinSolver expressoin = new ArthematicExpressoinSolver();
        assertEquals(expressoin.solve("5*4/(4-2)"), "10");
    }

    @Test
    public void doubleBracketTest() {
        ArthematicExpressoinSolver expressoin = new ArthematicExpressoinSolver();
        assertEquals(expressoin.solve("2*3+(10+3)+(3-1)/2"), "20");
    }

    @Test
    public void complexExpressionTest() {
        ArthematicExpressoinSolver expressoin = new ArthematicExpressoinSolver();
        assertEquals(expressoin.solve("2*3+(10+3)+(3-1)*(2^4)/2"), "35");
    }


}