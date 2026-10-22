package com.example.baitapgiaodien

import java.io.Serializable

data class Student(
    val name: String,
    val email: String,
    val phone: String,
    val studentId: String,
    val className: String
) : Serializable