package com.prjgrp.artf.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prjgrp.artf.Model.History;
import com.prjgrp.artf.Service.HistoryService;


@RestController
@RequestMapping("/histories")
public class HistoryController {
    @Autowired
    HistoryService historyService;
    @PostMapping
    public History postHistory(@RequestBody History history){
         return historyService.postHistory(history);
    }
    @GetMapping
    public List<History> getHistory(){
         return historyService.getHistory();
    }
     @GetMapping("/{id}")
    public Optional<History> getHistoryById(@PathVariable int id) {
        return historyService.getHistoryById(id);
    }

    @PutMapping("/{id}")
    public History updateHistory(@PathVariable int id, @RequestBody History updated) {
        return historyService.updateHistory(id, updated);
    }

    @DeleteMapping("/{id}")
    public String deleteHistory(@PathVariable int id) {
        return historyService.deleteHistory(id) ? "User Deleted" : "User Not Found";
    }
    @GetMapping("/sorted")
    public Page<History> getAllSortedHistory(@RequestParam int page, @RequestParam int size,@RequestParam String sortBy ,@RequestParam String sortDirection) {
        return historyService.getAllSortedHistory(page, size,sortBy,sortDirection);
    }

}
