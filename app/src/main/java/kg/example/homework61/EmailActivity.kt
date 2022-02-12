package kg.example.homework61

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kg.example.homework61.databinding.ActivityEmailBinding

class EmailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEmailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvActivity.setText(intent.getStringExtra("edit_text"))

        binding.btnExit.setOnClickListener {
            setResult(
                RESULT_OK, Intent().putExtra(
                    "result", binding.tvActivity.text.toString()
                )
            )
            finish()
        }
    }
}