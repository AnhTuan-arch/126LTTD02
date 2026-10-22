package com.example.baitapgiaodien

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.example.baitapgiaodien.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            if (validateForm()) {
                val student = Student(
                    name = binding.edtName.text.toString().trim(),
                    email = binding.edtEmail.text.toString().trim(),
                    phone = binding.edtPhone.text.toString().trim(),
                    studentId = binding.edtStudentId.text.toString().trim(),
                    className = binding.edtClass.text.toString().trim()
                )

                // Chuyển qua màn hình chi tiết
                val intent = Intent(this, DetailActivity::class.java).apply {
                    putExtra("STUDENT_DATA", student)
                }
                startActivity(intent)
            }
        }
    }

    private fun validateForm(): Boolean {
        var isValid = true

        val name = binding.edtName.text.toString().trim()
        val email = binding.edtEmail.text.toString().trim()
        val phone = binding.edtPhone.text.toString().trim()
        val studentId = binding.edtStudentId.text.toString().trim()
        val className = binding.edtClass.text.toString().trim()

        // Validate Họ tên
        if (name.isEmpty()) {
            binding.tilName.error = "Họ tên không được để trống"
            isValid = false
        } else {
            binding.tilName.error = null
        }

        // Validate Email
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.tilEmail.error = "Email không hợp lệ"
            isValid = false
        } else {
            binding.tilEmail.error = null
        }

        // Validate SĐT
        val phoneRegex = "^0[0-9]{9}$".toRegex()
        if (phone.isEmpty() || !phone.matches(phoneRegex)) {
            binding.tilPhone.error = "Số điện thoại không hợp lệ (gồm 10 số, bắt đầu bằng 0)"
            isValid = false
        } else {
            binding.tilPhone.error = null
        }

        // Validate MSV
        if (studentId.isEmpty()) {
            binding.tilStudentId.error = "Mã sinh viên không được để trống"
            isValid = false
        } else {
            binding.tilStudentId.error = null
        }

        // Validate Lớp
        if (className.isEmpty()) {
            binding.tilClass.error = "Lớp không được để trống"
            isValid = false
        } else {
            binding.tilClass.error = null
        }

        return isValid
    }
}