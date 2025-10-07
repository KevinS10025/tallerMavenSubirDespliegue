package com.jdc.tecertaller.Repository;


import com.jdc.tecertaller.Entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
