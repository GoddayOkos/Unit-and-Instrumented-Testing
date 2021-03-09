package dev.decagon.godday.registrationform.units

import dev.decagon.godday.registrationform.units.Validators
import org.junit.Assert.*
import org.junit.Test

class ValidatorsTest {

    @Test
    fun isPhoneNumberValid_givenValidInputs_returnsTrue() {

        // Given sets of valid Nigerian phones numbers
        val phoneNumber = "08057084902"
        val phoneNumber2 = "2348057084902"
        val phoneNumber3 = "07057084902"
        val phoneNumber4 = "2347057084902"
        val phoneNumber5 = "09057084902"
        val phoneNumber6 = "2349057084902"

        // When the numbers are validated
        val result = Validators.isPhoneNumberValid(phoneNumber)
        val result2 = Validators.isPhoneNumberValid(phoneNumber2)
        val result3 = Validators.isPhoneNumberValid(phoneNumber3)
        val result4 = Validators.isPhoneNumberValid(phoneNumber4)
        val result5 = Validators.isPhoneNumberValid(phoneNumber5)
        val result6 = Validators.isPhoneNumberValid(phoneNumber6)

        // Then the results should be true
        assertTrue(result)
        assertEquals(true, result2)
        assertTrue(result3)
        assertTrue(result4)
        assertTrue(result5)
        assertTrue(result6)
    }

    @Test
    fun isPhoneNumberValid_givenInvalidInputs_returnsFalse() {

        // Given sets of invalid Nigerian phones numbers
        val phoneNumber = " "
        val phoneNumber2 = "234805708490237485958463"
        val phoneNumber3 = "01057084902"
        val phoneNumber4 = "2346057084902"
        val phoneNumber5 = "04057084902"
        val phoneNumber6 = "23490570849022"

        // When the numbers are validated
        val result = Validators.isPhoneNumberValid(phoneNumber)
        val result2 = Validators.isPhoneNumberValid(phoneNumber2)
        val result3 = Validators.isPhoneNumberValid(phoneNumber3)
        val result4 = Validators.isPhoneNumberValid(phoneNumber4)
        val result5 = Validators.isPhoneNumberValid(phoneNumber5)
        val result6 = Validators.isPhoneNumberValid(phoneNumber6)

        // Then the results should be false
        assertFalse(result)
        assertEquals(false, result2)
        assertFalse(result3)
        assertFalse(result4)
        assertFalse(result5)
        assertFalse(result6)
    }

    @Test
    fun isInvalidName_givenInvalidNames_returnsTrue() {
        // Given invalid names
        val name1 = "123John"
        val name2 = ""

        // When the names validated
        val result1 = Validators.isInvalidName(name1)
        val result2 = Validators.isInvalidName(name2)

        // Then the results should be true
        assertEquals(true, result1)
        assertTrue(result2)
    }

    @Test
    fun isInvalidName_givenValidNames_returnsFalse() {
        // Given valid names
        val name1 = "John"
        val name2 = "smith_45"

        // When the names validated
        val result1 = Validators.isInvalidName(name1)
        val result2 = Validators.isInvalidName(name2)

        // Then the results should be false because they are not invalid
        assertEquals(false, result1)
        assertFalse(result2)
    }

    @Test
    fun isEmailValid_givenValidEmails_returnTrue() {
        // Given
        val email = "goddayokos@gmail.com"
        val email2 = "g@g.c"

        // When
        val result = Validators.isEmailValid(email)
        val result2 = Validators.isEmailValid(email2)

        // Then
        assertTrue(result)
        assertTrue(result2)
    }

    @Test
    fun isEmailValid_givenInvalidEmails_returnFalse() {
        // Given
        val email = ""
        val email2 = "                   "
        val email3 = "jsmith.com"
        val email4 = " jsmith@gmail.com"
        val email5 = "@gmail.com"
        val email6 = "jsmith@.com"

        // When
        val result = Validators.isEmailValid(email)
        val result2 = Validators.isEmailValid(email2)
        val result3 = Validators.isEmailValid(email3)
        val result4 = Validators.isEmailValid(email4)
        val result5 = Validators.isEmailValid(email5)
        val result6 = Validators.isEmailValid(email6)

        // Then
        assertFalse(result)
        assertFalse(result2)
        assertFalse(result3)
        assertFalse(result4)
        assertFalse(result5)
        assertFalse(result6)
    }

}