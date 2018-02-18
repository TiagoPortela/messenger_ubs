package com.ubs.tiagoportela.messenger_ubs.repository;


import com.ubs.tiagoportela.messenger_ubs.models.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long>{
}
