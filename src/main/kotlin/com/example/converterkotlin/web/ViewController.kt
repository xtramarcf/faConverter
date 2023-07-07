//package com.example.converterkotlin.web
//
//import com.example.converterkotlin.service.ExcelFilesService
//import org.springframework.stereotype.Controller
//import org.springframework.web.bind.annotation.PostMapping
//import org.springframework.web.bind.annotation.RequestMapping
//
//@Controller
//class ViewController(val excelFilesService: ExcelFilesService) {
//
//    @RequestMapping("/view")
//    fun view(): String {
//        return "view"
//    }
//
//    @PostMapping("/convertToCircuitExcelFile")
//    fun convertToCircuitExcelFile(): String {
//        excelFilesService.createFiles()
//
//        return "redirect:view"
//    }
//}