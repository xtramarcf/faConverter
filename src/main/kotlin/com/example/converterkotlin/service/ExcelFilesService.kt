//package com.example.converterkotlin.service
//
//import com.example.converterkotlin.model.ExportData
//import org.apache.poi.ss.usermodel.Row
//import org.apache.poi.xssf.usermodel.XSSFSheet
//import org.apache.poi.xssf.usermodel.XSSFWorkbook
//import org.springframework.stereotype.Service
//import java.io.File
//import java.io.FileOutputStream
//
//
//@Service
//class ExcelFilesService(val dataService: DataService, val readerService: ReaderService) {
//
//    private val LANGUAGES = arrayOf("DE", "EN", "FR", "ES", "RU", "PL")
//
//    private val ELECTRICAL_CIRCUIT_TRANSLATIONS = arrayOf(
//        "Schaltplan",
//        "Circuit Diagramm",
//        "Schéma",
//        "Diagrama de circuito",
//        "printsipial'naya elektricheskaya skhema",
//        "Schemat obwodu"
//    )
//
//    /*
//     *
//     * First reads all the content and puts them into the val 'exportDataList'
//     * Creates and fills the two .xlsx files, which are needed for importing data to freund assistance.
//     *
//     */
//
//    fun createFiles() {
//
//        val exportDataList: MutableList<ExportData> = readerService.readContent()
//        detectMultipleDrawings(exportDataList)
//        val fileNames = getFileNames()
//
//        // Creates document 'planToSerialNumber'
//        val workbook1 = XSSFWorkbook()
//        val sheet1 = workbook1.createSheet("Tabelle")
//        val out1 = FileOutputStream(fileNames[0])
//        writePlanToSerialNumber(sheet1, exportDataList)
//        workbook1.write(out1)
//        out1.close()
//
//        // Creates document 'planToDocument'
//        val workbook2 = XSSFWorkbook()
//        val sheet2 = workbook2.createSheet("Tabelle")
//        val out2 = FileOutputStream(fileNames[1])
//        writePlanToDocument(sheet2, exportDataList)
//        workbook2.write(out2)
//        out2.close()
//    }
//
//    /*
//     *
//     * @Param: sheet1 -> The sheet is the table of the excel-file, where the content is written.
//     * @Param: exportDataList -> Contents the whole data.
//     * Writes the content in the excel-table of the 'PlanToSerialNumber'-file.
//     *
//     */
//
//    private fun writePlanToSerialNumber(sheet: XSSFSheet, exportDataList: MutableList<ExportData>) {
//
//        var row = sheet.createRow(0)
//        var rowNr = 1
//        var languageCount = 0
//        writeTitlesPlanToSerialNumber(row)
//
//        for (exportData in exportDataList) {
//            while (languageCount < 6) {
//                val splitDataName = getCircuitFileName(exportData.teilenummer).split(".pdf")
//                row = sheet.createRow(rowNr)
//                row.createCell(2).setCellValue(exportData.serienNummer)
//                row.createCell(3).setCellValue(exportData.rmnr)
//                row.createCell(4).setCellValue(splitDataName[0])
//                row.createCell(5).setCellValue(LANGUAGES[languageCount])
//                if (exportData.anzahlPlaene == 0) {
//                    row.createCell(6)
//                        .setCellValue(ELECTRICAL_CIRCUIT_TRANSLATIONS[languageCount])
//                } else {
//                    row.createCell(6)
//                        .setCellValue(ELECTRICAL_CIRCUIT_TRANSLATIONS[languageCount] + " " + exportData.anzahlPlaene)
//                }
//                row.createCell(9).setCellValue("INSERT")
//                languageCount++
//                rowNr++
//            }
//            languageCount = 0
//        }
//    }
//
//    /*
//     *
//     * @Param: sheet1 -> The sheet is the table of the excel-file, where the content is written.
//     * @Param: exportDataList -> Contents the whole data.
//     * Writes the content in the excel-table of the 'PlanToDocument'-file.
//     *
//     */
//
//    private fun writePlanToDocument(sheet: XSSFSheet, exportDataList: MutableList<ExportData>) {
//
//        var row = sheet.createRow(0)
//        var rowNr = 1
//        var languageCount = 0
//        writeTitlesPlanToDocument(row)
//
//        for (exportData in exportDataList) {
//            while (languageCount < 6) {
//                row = sheet.createRow(rowNr)
//                val splitDataName = getCircuitFileName(exportData.teilenummer).split(".pdf")
//                row.createCell(0).setCellValue(LANGUAGES[languageCount])
//                row.createCell(1).setCellValue(splitDataName[0])
//                row.createCell(3).setCellValue(getCircuitFileName(exportData.teilenummer))
//                row.createCell(4).setCellValue(splitDataName[0])
//                row.createCell(5).setCellValue("INSERT")
//
//                languageCount++
//                rowNr++
//            }
//            languageCount = 0
//        }
//    }
//
//    /*
//     *
//     * @Param: sheet1 -> The sheet is the table of the excel-file, where the content is written.
//     * @Param: exportDataList -> Contents the whole data.
//     * Writes the content in the excel-table of the 'PlanToSerialNumber'-file.
//     *
//     */
//
//    private fun getFileNames(): Array<String> {
//        val outputFolder = dataService.getPath("Output Directory")
//        val fileNameToSerialNumber1 = outputFolder + dataService.getFileName(1) + ".xlsx"
//        val fileNameToDocument2 = outputFolder + dataService.getFileName(2) + ".xlsx"
//
//        return arrayOf(fileNameToSerialNumber1, fileNameToDocument2)
//    }
//
//
//    /*
//     *
//     * Writes the titles for all columns in the first row of the document 'PlanToSerialNumber'
//     *
//     */
//
//    private fun writeTitlesPlanToSerialNumber(row: Row) {
//        row.createCell(0).setCellValue("Material")
//        row.createCell(1).setCellValue("Material version")
//        row.createCell(2).setCellValue("Assembly Number")
//        row.createCell(3).setCellValue("Assembly version")
//        row.createCell(4).setCellValue("Doku Nr.")
//        row.createCell(5).setCellValue("Sprache")
//        row.createCell(6).setCellValue("Titel")
//        row.createCell(7).setCellValue("Chapter")
//        row.createCell(8).setCellValue("Chapter ref")
//        row.createCell(9).setCellValue("Action during Import")
//    }
//
//    /*
//     *
//     * Writes the titles for all columns in the first row of the document 'PlanToDocument'
//     *
//     */
//
//    private fun writeTitlesPlanToDocument(row: Row) {
//        row.createCell(0).setCellValue("Sprache")
//        row.createCell(1).setCellValue("Doku Nr.")
//        row.createCell(2).setCellValue("Doku Version")
//        row.createCell(3).setCellValue("Dokument")
//        row.createCell(4).setCellValue("Titel")
//        row.createCell(5).setCellValue("Action during Import")
//    }
//
//    /*
//     *
//     * Param: teileNummer -> partNumber of the electrical circuit drawing.
//     * Returns the name of the found file in the folder with all actual electrical circuit drawings.
//     *
//     */
//
//    private fun getCircuitFileName(teileNummer: String): String {
//
//        val files = File(dataService.getPath("Electrical Circuit Directory")).listFiles()
//        var fileName = ""
//
//        if (files != null) {
//            for (value in files) {
//                if (value.name.startsWith(teileNummer)) fileName = value.name
//            }
//        }
//
//        return fileName
//    }
//
//    /*
//     *
//     * @Param: exportDataList -> contents all the read data.
//     *
//     */
//
//    private fun detectMultipleDrawings(exportDataList: List<ExportData>) {
//
//        var count = 0
//        val serialNumbers = arrayOfNulls<String>(exportDataList.size + 1)
//        for (it in exportDataList) {
//            serialNumbers[count] = exportDataList[count].serienNummer
//            count++
//        }
//
//        count = 0
//
//        while (serialNumbers[count] != null) {
//            var drawingNumber = 1
//            if (serialNumbers[count] == serialNumbers[count + 1]) {
//                exportDataList[count].anzahlPlaene = drawingNumber
//                drawingNumber++
//                exportDataList[count + 1].anzahlPlaene = drawingNumber
//                drawingNumber++
//                count++
//            }
//            while (serialNumbers[count] == serialNumbers[count + 1]) {
//                exportDataList[count + 1].anzahlPlaene = drawingNumber
//                drawingNumber++
//                count++
//            }
//            count++
//        }
//    }
//
//}