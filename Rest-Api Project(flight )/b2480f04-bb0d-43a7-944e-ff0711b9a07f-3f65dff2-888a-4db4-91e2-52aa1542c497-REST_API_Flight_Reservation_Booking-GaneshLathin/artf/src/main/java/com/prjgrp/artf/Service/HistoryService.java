package com.prjgrp.artf.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.*;
import org.springframework.stereotype.Service;

import com.prjgrp.artf.Model.History;
import com.prjgrp.artf.Repository.HistoryRepository;
@Service
public class HistoryService {

@Autowired
HistoryRepository historyRepository;
public History postHistory(History history)
{
    return historyRepository.save(history);
}
public List<History> getHistory()
{
    return historyRepository.findAll();
}
public Optional<History> getHistoryById(int id) {
  return historyRepository.findById(id);
}
public History updateHistory(int id, History updated) {
    updated.setId(id);
  return historyRepository.save(updated);
}
public boolean deleteHistory(int id) {
   if(historyRepository.existsById(id)){
        historyRepository.deleteById(id);
        return true;
   }
   return false;
}
public Page<History> getAllSortedHistory(int page,int size,String sortBy,String sortDirection)
    {
        Sort sort = Sort.by(sortDirection.equalsIgnoreCase("desc") ? Direction.DESC : Direction.ASC, sortBy);
        return historyRepository.findAll(PageRequest.of(page,size,sort));
    }
}
