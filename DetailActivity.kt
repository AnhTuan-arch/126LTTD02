package com.example.baitapgiaodien

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.baitapgiaodien.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Nhận dữ liệu từ Intent
        val student = intent.getSerializableExtra("STUDENT_DATA") as? Student

        student?.let {
            val displayInfo = """
                Họ và tên: ${it.name}
                Email: ${it.email}
                Số điện thoại: ${it.phone}
                Mã sinh viên: ${it.studentId}
                Lớp: ${it.className}
            """.trimIndent()

            binding.tvInfo.text = displayInfo
        }

        // Nút quay lại màn hình trước
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}