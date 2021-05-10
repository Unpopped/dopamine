package com.example.dopamine.repositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.dopamine.domain.toDo;

@Repository
public interface toDoRepository extends PagingAndSortingRepository<toDo, Long>{

}


