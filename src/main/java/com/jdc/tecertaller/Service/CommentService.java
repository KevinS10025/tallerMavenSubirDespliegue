package com.jdc.tecertaller.Service;

import com.jdc.tecertaller.Entities.Comment;
import com.jdc.tecertaller.Repository.CommentREpository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentREpository commentRepository;

    public CommentService(CommentREpository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment updateComment(Long id, Comment commentDetails) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentario no encontrado"));

        comment.setContent(commentDetails.getContent());

        return commentRepository.save(comment);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}