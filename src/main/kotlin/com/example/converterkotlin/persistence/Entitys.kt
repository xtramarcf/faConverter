package com.example.converterkotlin.persistence

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity(name = "files")
class File (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id") var id : Int,
    @Column(name = "name") var name : String
)

@Entity(name = "paths")
class Path (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id") var id : Int,
    @Column(name = "name") var name : String,
    @Column(name = "path") var path : String
)

@Entity(name = "history")
class History (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id") var id : Int,
    @Column(name = "timestamp") var timestamp : String
)