package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScholarshipCalculatorTest {

    private final ScholarshipCalculator calculator =
            new ScholarshipCalculator();

    @Test
    void letterGradeReturnsAFor95() {
        assertEquals("A", calculator.letterGrade(95));
    }

    @Test
    void letterGradeReturnsDFor65() {
        assertEquals("D", calculator.letterGrade(65));
    }

    @Test
    void gpaReturnsAverageForTwoScores() {
        assertEquals(
                3.5,
                calculator.gpa(new double[]{95, 85}),
                0.000001
        );
    }

    @Test
    void scholarshipReturns100ForHighGpaAndEnoughCredits() {
        assertEquals(
                100,
                calculator.scholarship(3.9, 16, false)
        );
    }

    @Test
    void scholarshipReturns70ForEligibleStudent() {
        assertEquals(
                70,
                calculator.scholarship(3.5, 12, false)
        );
    }
}
