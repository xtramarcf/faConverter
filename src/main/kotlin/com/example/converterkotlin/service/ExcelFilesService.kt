package com.example.converterkotlin.service

import com.example.converterkotlin.model.ExportData
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.stereotype.Service
import java.io.File
import java.io.FileOutputStream


@Service
class ExcelFilesService(val dataService: DataService) {

    private val LANGUAGES = arrayOf("DE", "EN", "FR", "ES", "RU", "PL")

    private val ELECTRICAL_CIRCUIT_TRANSLATIONS = arrayOf(
        "Schaltplan",
        "Circuit Diagramm",
        "Schéma",
        "Diagrama de circuito",
        "printsipial'naya elektricheskaya skhema",
        "Schemat obwodu"
    )

    /*
     *
     * Param: exportDataList -> Is the list with all the read data out of the pa-export-files.
     * Creates and fills the two .xlsx files, which are needed for importing data to freund assistance.
     *
     */


    fun createFiles(exportDataList: List<ExportData>) {
        val workbook = XSSFWorkbook()
        val outputFolder = dataService.getPath("Output Directory")
        val fileNameToSerialNumber1 = outputFolder+dataService.getFileName(1)+".xlsx"
        val fileNameToDocument2 = outputFolder+dataService.getFileName(2)+".xlsx"

            workbook.write(FileOutputStream(File()))
    }

    /*
     * Writes the titles for all columns in the first row of the document 'PlanToSerialNumber'
     */

    fun writeTitlesPlanToSerialNumber(row: Row) {
        row.createCell(0).setCellValue("Material")
        row.createCell(1).setCellValue("Material version")
        row.createCell(2).setCellValue("Assembly Number")
        row.createCell(3).setCellValue("Assembly version")
        row.createCell(4).setCellValue("Doku Nr.")
        row.createCell(5).setCellValue("Sprache")
        row.createCell(6).setCellValue("Titel")
        row.createCell(7).setCellValue("Chapter")
        row.createCell(8).setCellValue("Chapter ref")
        row.createCell(9).setCellValue("Action during Import")
    }

    /*
     * Writes the titles for all columns in the first row of the document 'PlanToDocument'
     */

    fun writeTitlesPlanToDocument(row: Row) {
        row.createCell(0).setCellValue("Sprache")
        row.createCell(1).setCellValue("Doku Nr.")
        row.createCell(2).setCellValue("Doku Version")
        row.createCell(3).setCellValue("Dokument")
        row.createCell(4).setCellValue("Titel")
        row.createCell(5).setCellValue("Action during Import")
    }

    /*
     *
     * Param: teileNummer -> partNumber of the electrical circuit drawing.
     * Returns the name of the found file in the folder with all actual electrical circuit drawings.
     *
     */

    fun getCircuitFileName(teileNummer: String): String {

        val files = File(dataService.getPath("Electrical Circuit Directory")).listFiles()
        var fileName = ""

        if (files != null) {
            for (value in files) {
                if (value.name.startsWith(teileNummer)) fileName = value.name
            }
        }

        return fileName
    }
}