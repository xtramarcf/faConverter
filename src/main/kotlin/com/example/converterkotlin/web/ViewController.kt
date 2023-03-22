package com.example.converterkotlin.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class ViewController {

    @RequestMapping( "/view")
    fun view(): String{
        return "view"
    }
}