package dev.decagon.godday.registrationform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import dev.decagon.godday.registrationform.units.Validators
import java.util.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var genderSelector: Spinner
    private val genderList = listOf("", "male", "female")
    private  var userGender: String = ""
    private lateinit var firstName: TextView
    private lateinit var lastName: TextView
    private lateinit var phoneNumber: TextView
    private lateinit var email: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Hook the spinner up with a custom view and load it with data from the genderList
        genderSelector = findViewById(R.id.spinner)
        val adapter = ArrayAdapter(this, R.layout.spinner_items, genderList)
        genderSelector.adapter = adapter
        genderSelector.onItemSelectedListener = this

        // Capture user inputs
        firstName = findViewById(R.id.firstName)
        lastName = findViewById(R.id.lastName)
        phoneNumber = findViewById(R.id.phone)
        email = findViewById(R.id.email)


        // Setup submit button to listen to clicks and perform appropriate action
        val submitButton = findViewById<Button>(R.id.button)
        submitButton.setOnClickListener {
            validateAndSubmit()
        }
    }

    // Validate user input and submit if all inputs are valid else, notify the user accordingly
    private fun validateAndSubmit() {
        val phone = phoneNumber.text.toString()
        val fName = firstName.text.toString()
        val lName = lastName.text.toString()
        val email1 = email.text.toString()

        if (Validators.isInvalidName(fName)) {
            firstName.error = "Enter a valid first name!"
        } else if (Validators.isInvalidName(lName)) {
            lastName.error = "Enter a valid last name!"
        } else if (!Validators.isPhoneNumberValid(phone)) {
            phoneNumber.error = "Enter a valid Nigerian phone number"
        }else if (!Validators.isEmailValid(email1)) {
            email.error = "Enter a valid email address!"
        } else if (userGender == "") {
            Toast.makeText(this, "You must choose your sex!", Toast.LENGTH_SHORT).show()
        } else {
            createUserProfile()
            firstName.clear()
            lastName.clear()
            phoneNumber.clear()
            email.clear()
        }
    }

    // Implement abstract methods and capture user gender
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when (position) {
            0 -> {userGender = genderList[0]}
            1 -> { userGender = genderList[1] }
            2 -> { userGender = genderList[2] }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    // Passing user information to the next activity
    private fun createUserProfile() {
        val fullName = "${firstName.text.toString().capitalize(Locale.ROOT)} ${
            lastName.text.toString().capitalize(
            Locale.ROOT
        )
        }"
        val intent = Intent(this, ProfileActivity::class.java)
        intent.putExtra(ProfileActivity.FULL_NAME, fullName)
        intent.putExtra(ProfileActivity.PHONE_NUMBER, (phoneNumber.text).toString())
        intent.putExtra(ProfileActivity.EMAIL, (email.text).toString())
        intent.putExtra(ProfileActivity.GENDER, userGender)
        startActivity(intent)
    }

    // Extension function to clear user input
    private fun TextView.clear() {
        this.text = null
    }
}