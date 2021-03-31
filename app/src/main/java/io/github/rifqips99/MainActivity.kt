package io.github.rifqips99

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var buttonSubmit: Button
    private lateinit var etNama: EditText
    private lateinit var etNim: EditText
    private lateinit var rgGender: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNama = findViewById(R.id.et_nama)
        etNim = findViewById(R.id.et_nim)
        rgGender = findViewById(R.id.rg_gender)
        buttonSubmit = findViewById(R.id.btn_submit)

        buttonSubmit.setOnClickListener {
            val nama = etNama.text.toString()
            val nim = etNim.text.toString()
            val gender: String = when (rgGender.checkedRadioButtonId) {
                R.id.rb_male -> "Laki-laki"
                R.id.rb_female -> "Perempuan"
                else -> ""
            }

            Log.e("TAG", "onCreate() called ${rgGender.checkedRadioButtonId}")

            val extras = Bundle().apply {
                putString("nama", nama)
                putString("nim", nim)
                putString("gender", gender)
            }

            val intentGotoData = Intent(this, DataActivity::class.java).apply {
//                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                putExtras(extras)
            }
            startActivity(intentGotoData)
        }
    }

}