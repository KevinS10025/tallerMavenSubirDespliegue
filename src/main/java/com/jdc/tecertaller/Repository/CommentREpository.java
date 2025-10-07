package com.jdc.tecertaller.Repository;

import com.jdc.tecertaller.Entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentREpository extends JpaRepository <Comment, Long> {
}
