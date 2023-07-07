package com.example.converterkotlin.persistence.pa

import jakarta.persistence.*

@Entity
@Table(name = "pa")
class Pa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null


}