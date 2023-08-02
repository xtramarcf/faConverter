package com.example.converterkotlin.persistence.pa

import jakarta.persistence.*
import java.util.Date

@Entity (name = "V_BelegKopf")
class Pa {

    @Id
    val id: Int? = 0

    @Column(name="Kunde")
    val kunde: String? = null

    @Column(name="BelegArt")
    val belegArt: String? = null

    @Column(name="BelegDatum")
    val belegDatum: Date? = null

    @Column(name="AnlageDatum")
    val anlageDatum: Date? = null
}
