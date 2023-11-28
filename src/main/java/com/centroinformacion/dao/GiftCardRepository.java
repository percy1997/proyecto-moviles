package com.centroinformacion.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.centroinformacion.entity.GiftCard;

public interface GiftCardRepository extends JpaRepository<GiftCard, Integer> {

}
