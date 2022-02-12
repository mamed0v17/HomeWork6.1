package kg.example.homework61

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvMail: EditText
    private lateinit var registerForActivityResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvMail = findViewById(R.id.tv_mail)

        findViewById<Button>(R.id.btn_go).setOnClickListener {
            if (tvMail.text.toString().isEmpty()) {
                Toast.makeText(this, "Вы нечего не написали", Toast.LENGTH_SHORT).show()
            } else {
                Intent(this@MainActivity, EmailActivity::class.java).apply {
                    putExtra("edit_text", tvMail.text.toString())
                    registerForActivityResult.launch(this)
                }
            }
        }
        registerForActivityResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            tvMail.setText(result.data?.getStringExtra("result"))
        }
    }
}