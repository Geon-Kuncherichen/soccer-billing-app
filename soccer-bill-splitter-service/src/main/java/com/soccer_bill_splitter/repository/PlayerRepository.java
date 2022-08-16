package com.soccer_bill_splitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soccer_bill_splitter.entity.Player;


public interface PlayerRepository extends JpaRepository<Player, Long>
{

}
