package com.sofusit.poalimbootstrap.data.repository;

import com.sofusit.poalimbootstrap.data.entity.Sign;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SignRepo  extends CrudRepository<Sign, String> {

    Optional<Sign> findById(String id);
}
