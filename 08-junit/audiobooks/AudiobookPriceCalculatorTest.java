package put.io.testing.audiobooks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudiobookPriceCalculatorTest {
    private AudiobookPriceCalculator calc;
    private Customer customer;
    private Audiobook audiobook;

    @BeforeEach
    public void setUp() {
        this.calc = new AudiobookPriceCalculator();
        this.audiobook = new Audiobook("Audiobook", 100);
    }

    @Test
    public void test1() {
        this.customer = new Customer("Kowalski", Customer.LoyaltyLevel.STANDARD, false);
        double val = this.calc.calculate(this.customer, this.audiobook);
        assertEquals(this.audiobook.getStartingPrice(), val);
    }

    @Test
    public void test2() {
        this.customer = new Customer("Kowalski", Customer.LoyaltyLevel.SILVER, false);
        double val = this.calc.calculate(this.customer, this.audiobook);
        assertEquals(this.audiobook.getStartingPrice() * 0.9, val);
    }

    @Test
    public void test3() {
        this.customer = new Customer("Kowalski", Customer.LoyaltyLevel.GOLD, false);
        double val = this.calc.calculate(this.customer, this.audiobook);
        assertEquals(this.audiobook.getStartingPrice() * 0.8, val);
    }

    @Test
    public void test4() {
        this.customer = new Customer("Kowalski", Customer.LoyaltyLevel.STANDARD, true);
        double val = this.calc.calculate(this.customer, this.audiobook);
        assertEquals(0, val);
    }

    @AfterEach
    public void tearDown() {
        this.audiobook = null;
        this.customer = null;
        this.calc = null;
    }

}