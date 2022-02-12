package kg.example.homework61

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kg.example.homework61.databinding.ActivityEmailBinding

class EmailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEmailBinding

    companion object {
        const val KEY1 = "edit_text"
        const val KEY2 = "result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvActivity.setText(intent.getStringExtra(KEY1))

        binding.btnExit.setOnClickListener {
            setResult(
                RESULT_OK, Intent().putExtra(
                    KEY2, binding.tvActivity.text.toString()
                )
            )
            finish()
        }
    }
}