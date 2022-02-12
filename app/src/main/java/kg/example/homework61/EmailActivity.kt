package kg.example.homework61

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class EmailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)

        val text = findViewById<EditText>(R.id.tv_activity)
        text.setText(intent.getStringExtra("edit_text"))

        findViewById<Button>(R.id.btn_exit).setOnClickListener {
            setResult(RESULT_OK,Intent().putExtra("result",text.text.toString()))
            finish()
        }
    }
}