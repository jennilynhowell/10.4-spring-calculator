package com.jennilyn.interfaces;

import com.jennilyn.models.CalcUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<CalcUser, Long>{}
