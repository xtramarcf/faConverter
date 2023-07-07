//package com.example.converterkotlin.service
//
//import com.example.converterkotlin.model.ExportData
//import org.springframework.stereotype.Service
//import java.io.File
//import java.util.*
//import kotlin.collections.ArrayList
//
//@Service
//class ReaderService(val dataService: DataService) {
//
//    /*
//     *
//     * @Param: List of all csv-file paths, which should be read.
//     * Reads a file and put the data in a list of Export Data.
//     * Returns a merged list with all Export Data.
//     *
//     */
//
//    fun readContent(): MutableList<ExportData> {
//
//        val dateiPfad = getFilePaths()
//        val content: MutableList<MutableList<ExportData>> = MutableList(dateiPfad.size) { ArrayList() }
//        for (i in dateiPfad.indices) {
//            val file = File(dateiPfad[i])
//            val scanner = Scanner(file, "Cp1252")
//
//            if (scanner.hasNext()) scanner.nextLine()
//
//            while (scanner.hasNext()) {
//                val line = scanner.nextLine()
//                val values = line.split(";")
//                content[i].add(ExportData(values[0], values[1], values[2], values[3]))
//            }
//            scanner.close()
//        }
//
//        return mergeContent(content)
//    }
//
//    /*
//     *
//     * @Param: List of mutable lists with all Export Data out  of multiple files.
//     * Merges the Lists and returns a list of Export Data.
//     *
//     */
//
//    private fun mergeContent(content: List<MutableList<ExportData>>): MutableList<ExportData> {
//
//        var mergedContent: MutableList<ExportData> = ArrayList()
//
//        for (data in content) {
//            mergedContent.addAll(data)
//        }
//        return mergedContent
//    }
//
//    /*
//     *
//     * Returns a list of the files with the id 1 (PlanToSerialNumber) and the id 2 (PlanToDocument)
//     *
//     */
//
//    private fun getFilePaths() = listOf(
//        dataService.getPath("pa_export"),
//        dataService.getPath("pa_export1"),
//    )
//
//}