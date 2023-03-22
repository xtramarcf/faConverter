package com.example.converterkotlin.model

class ExportData(
    var serienNummer: String,
    var rmnr: String,
    var teilenummer: String,
    var gefundeneDatei: String,
) {
    var anzahlPlaene: Int = 0

    override fun toString(): String {

        return ("ElectricalDrawingExport [seriennummer= $serienNummer, rmnr= $rmnr , teilenummer=" +
                "$teilenummer, gefundeneDatei= $gefundeneDatei, anzahlPlaene= $anzahlPlaene]")
    }
}