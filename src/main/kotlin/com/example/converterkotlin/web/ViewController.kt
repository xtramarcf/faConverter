package com.example.converterkotlin.web

import com.example.converterkotlin.service.PaService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class ViewController(val erpDataService: PaService) {

    @RequestMapping("/view")
    fun view(): String {
        return "view"
    }

    @PostMapping("/getPaData")
    fun getErpData(): String {
//        erpDataService.getPaData()
        erpDataService.test()
        return "redirect:view"
    }


//    @PostMapping("/convertToCircuitExcelFile")
//    fun convertToCircuitExcelFile(): String {
//        excelFilesService.createFiles()
//
//        return "redirect:view"
//    }
}