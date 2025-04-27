package com.projects.pos.system.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.projects.pos.system.dto.response.ItemResponseDTO;
import com.projects.pos.system.entity.Item;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item,Long> {

    List<Item> findAllByActiveStatusEquals(Boolean flag);
    Page<Item> findAllByActiveStatusEquals(boolean b, PageRequest of);
}
