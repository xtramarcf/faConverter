package com.example.converterkotlin.persistence.pa

import org.springframework.data.jpa.repository.JpaRepository

interface PaRepository: JpaRepository<Pa, Long> {
}