package kg.example.homework61

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kg.example.homework61.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var registerForActivityResult: ActivityResultLauncher<Intent>

    companion object {
        const val KEY1 = "edit_text"
        const val KEY2 = "result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGo.setOnClickListener {
            if (binding.tvMail.text.toString().isEmpty()) {
                Toast.makeText(this, getString(R.string.Noo), Toast.LENGTH_SHORT).show()
            } else {
                Intent(this@MainActivity, EmailActivity::class.java).apply {
                    putExtra(KEY1, binding.tvMail.text.toString())
                    registerForActivityResult.launch(this)
                }
            }
        }
        registerForActivityResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            binding.tvMail.setText(result.data?.getStringExtra(KEY2))
        }
    }
}