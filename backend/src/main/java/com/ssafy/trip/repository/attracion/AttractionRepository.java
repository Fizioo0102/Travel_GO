package com.ssafy.trip.repository.attracion;

import com.ssafy.trip.Entity.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction,Integer>, AttractionRepositoryCustom {

}
