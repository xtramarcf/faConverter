package com.example.converterkotlin.service

import com.example.converterkotlin.persistence.pa.PaRepository
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat
import java.util.*


@Service
class PaService(private val paRepository: PaRepository) {


    fun formatDate(date: String): Date{
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
        return dateFormat.parse(date)
    }

    val startDate = formatDate("2023-07-03")
    val endDate = formatDate("2023-07-20")

    fun getPaData() {

        val data = paRepository.getCircuitExport(startDate, endDate)

        if (data != null) {
            for (str in data) {
                println(str)
            }
        }
    }

    fun test(){
        val data = paRepository.test()

        if (data != null) {
            for (str in data) {
                println(str)
            }
        }
    }
}