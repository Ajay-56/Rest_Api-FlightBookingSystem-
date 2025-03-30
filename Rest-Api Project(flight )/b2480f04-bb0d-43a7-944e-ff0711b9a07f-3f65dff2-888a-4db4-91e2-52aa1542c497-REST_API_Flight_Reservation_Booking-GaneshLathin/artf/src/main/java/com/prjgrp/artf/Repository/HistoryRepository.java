package com.prjgrp.artf.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prjgrp.artf.Model.History;

@Repository
public interface HistoryRepository extends JpaRepository<History,Integer>{

}
