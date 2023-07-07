//package com.example.converterkotlin.service
//
//import com.example.converterkotlin.persistence.FileRepository
//import com.example.converterkotlin.persistence.HistoryRepository
//import com.example.converterkotlin.persistence.PathRepository
//import org.springframework.stereotype.Service
//
//@Service
//class DataService(
//    private val fileRepository: FileRepository,
//    private val pathRepository: PathRepository,
//    private val historyRepository: HistoryRepository
//) {
//    fun getFileName(id: Int) = fileRepository.findById(id)
//
//    fun updateFileName(name: String, id: Int) {
//        fileRepository.updateFile(name, id)
//    }
//
//    fun getPath(name: String) = pathRepository.findByName(name)?.path
//
//    fun updatePath(path: String, name: String) {
//        pathRepository.updatePath(path, name)
//    }
//
//    fun getHistory(id: Int) = historyRepository.findById(id).get().timestamp
//
//    fun updateHistory(id: Int, timestamp: String) {
//        historyRepository.updateHistory(timestamp, id)
//    }
//}