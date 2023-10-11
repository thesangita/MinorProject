package com.tp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tp.entity.Destinations;

@Repository
public interface DestinationsRepository extends JpaRepository<Destinations, Long> {

}