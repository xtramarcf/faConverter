package com.example.converterkotlin.persistence.app

import jakarta.persistence.*

@Entity
@Table(name = "app")
class App {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null


}