package dev.decagon.godday.registrationform.units

object Validators {

    fun isInvalidName(name: String): Boolean {
        val regex = Regex("^([0-9]+([a-z|A-Z]+?)?|([!@#$%&*=|'+,./_-]+)|\\s+|\\+)")
        return name.matches(regex) || name.isEmpty()
    }

    // check if input is a valid email
    fun isEmailValid(email: String): Boolean {
        val regex = Regex("^[^@\\s\\.]+@[^@\\s]+\\.[^@\\s]+\$")
        return email.matches(regex)
       // return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches())
    }

    // Validate the user phone number
    fun isPhoneNumberValid(phone: String): Boolean {
        val regex1 = Regex("(234)([789])[0-9]{9}")
        val regex2 = Regex("(0)([789])[0-9]{9}")
        return phone.matches(regex1) || phone.matches(regex2)
    }
}