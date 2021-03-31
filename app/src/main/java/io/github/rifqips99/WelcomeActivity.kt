package io.github.rifqips99

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class WelcomeActivity : AppCompatActivity() {

    lateinit var etnama :EditText
    lateinit var btnsubmit :Button

    lateinit var prefutil: PreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        prefutil = PreferenceUtil.newInstance(this)

        etnama = findViewById(R.id.et_nama)
        btnsubmit = findViewById(R.id.btn_submit)

        etnama.setText(prefutil.getString("nama"))
        btnsubmit.setOnClickListener {
            saveData()
            val intentMainActivity = Intent (this, MainActivity ::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            startActivity(intentMainActivity)
        }
    }

    private fun saveData(){
        val nama = etnama.text.toString().trim()
        prefutil.setString("nama", nama)
        prefutil.setBoolean("is_login", true)
    }
}