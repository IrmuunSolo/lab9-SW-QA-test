package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void letterGradeReturnsBFor85() {
        assertEquals("B", calculator.letterGrade(85));
    }

    @Test
    void letterGradeReturnsCFor75() {
        assertEquals("C", calculator.letterGrade(75));
    }

    @Test
    void letterGradeReturnsFFor50() {
        assertEquals("F", calculator.letterGrade(50));
    }

    @Test
    void letterGradeRejectsNegativeScore() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.letterGrade(-1)
        );
    }

    @Test
    void letterGradeRejectsScoreAbove100() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.letterGrade(101)
        );
    }

    @Test
    void gpaHandlesEveryGrade() {
        assertEquals(
                2.0,
                calculator.gpa(new double[]{95, 85, 75, 65, 50}),
                0.000001
        );
    }

    @Test
    void gpaRejectsNullScores() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.gpa(null)
        );
    }

    @Test
    void gpaRejectsEmptyScores() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.gpa(new double[]{})
        );
    }

    @Test
    void scholarshipRejectsNegativeGpa() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.scholarship(-0.1, 15, false)
        );
    }

    @Test
    void scholarshipRejectsGpaAbove4() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.scholarship(4.1, 15, false)
        );
    }

    @Test
    void scholarshipRejectsNegativeCredits() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.scholarship(3.5, -1, false)
        );
    }

    @Test
    void scholarshipReturns0ForViolation() {
        assertEquals(
                0,
                calculator.scholarship(3.9, 16, true)
        );
    }

    @Test
    void scholarshipReturns70WhenCreditsBelow15() {
        assertEquals(
                70,
                calculator.scholarship(3.9, 14, false)
        );
    }

    @Test
    void scholarshipReturns50WhenCreditsBelow12() {
        assertEquals(
                50,
                calculator.scholarship(3.5, 11, false)
        );
    }

    @Test
    void scholarshipReturns0ForLowGpa() {
        assertEquals(
                0,
                calculator.scholarship(2.5, 12, false)
        );
    }
}
