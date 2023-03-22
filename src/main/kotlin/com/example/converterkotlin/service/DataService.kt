package com.example.converterkotlin.service

import com.example.converterkotlin.persistence.FileRepository
import com.example.converterkotlin.persistence.HistoryRepository
import com.example.converterkotlin.persistence.PathRepository
import org.springframework.stereotype.Service

@Service
class DataService(
    private val fileRepository: FileRepository,
    private val pathRepository: PathRepository,
    private val historyRepository: HistoryRepository
) {
    fun getFileName(id: Int): String {
        return fileRepository.findById(id).get().name
    }

    fun updateFileNmae(name: String, id: Int) {
        fileRepository.updateFile(name, id)
    }

    fun getPath(name: String): String {
        return pathRepository.findByName(name).get().path
    }

    fun updatePath(path: String, name: String) {
        pathRepository.updatePath(path, name)
    }

    fun getHistory(id: Integer): String {
        return historyRepository.findById(id).get().timestamp
    }

    fun updateHistory(id: Int, timestamp: String) {
        historyRepository.updateHistory(timestamp, id)
    }
}