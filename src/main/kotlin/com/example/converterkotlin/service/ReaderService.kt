package com.example.converterkotlin.service

import com.example.converterkotlin.model.ExportData
import org.springframework.stereotype.Service
import java.io.File
import java.util.*
import kotlin.collections.ArrayList

@Service
class ReaderService {

    fun readContent(dateiPfad: List<String>): MutableList<ExportData> {

        var content : List<MutableList<ExportData>> = listOf(ArrayList())
        for (i in 0..dateiPfad.size){
            val file =  File(dateiPfad[i])
            val scanner = Scanner(file, "Cp1252")

            if(scanner.hasNext()) scanner.nextLine()

            while(scanner.hasNext()){
                val line = scanner.nextLine()
                val values = line.split(";")

                content[i].add(ExportData(values[0], values[1], values[2], values[3]))
            }
            scanner.close()
        }

        return mergeContent(content)
    }



    fun mergeContent(content: List<MutableList<ExportData>>): MutableList<ExportData> {

        var mergedContent : MutableList<ExportData> = ArrayList()

        for(data in content){
            mergedContent.addAll(data)
        }
        return mergedContent
    }
}