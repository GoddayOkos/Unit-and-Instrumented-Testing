package dev.decagon.godday.registrationform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {
    private lateinit var profilePic: ImageView

    // Fields for holding and retrieving user details
    companion object {
        const val FULL_NAME = "fullName"
        const val PHONE_NUMBER = "phoneNumber"
        const val EMAIL = "email"
        const val GENDER = "gender"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        profilePic = findViewById(R.id.profileImage)
        setupViews()
    }

    // Setup the profile page with the users input
    private fun setupViews() {
        findViewById<TextView>(R.id.fullName).text = getString(R.string.name, intent.getStringExtra(FULL_NAME))
        findViewById<TextView>(R.id.phoneNumber).text = getString(R.string.phone_number, intent.getStringExtra(PHONE_NUMBER))
        findViewById<TextView>(R.id.userEmail).text = getString(R.string.email, intent.getStringExtra(EMAIL))
        findViewById<TextView>(R.id.gender).text = getString(R.string.gender_profile, intent.getStringExtra(GENDER))

        // use the appropriate avatar for profile image base on gender
        if (intent.getStringExtra(GENDER) == "female") {
            profilePic.setImageResource(R.drawable.profile_female)
        } else {
            profilePic.setImageResource(R.drawable.profile_img)
        }
    }
}