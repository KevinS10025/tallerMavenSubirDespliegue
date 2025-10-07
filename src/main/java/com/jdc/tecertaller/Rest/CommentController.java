package com.jdc.tecertaller.Rest;

import com.jdc.tecertaller.Entities.Comment;
import com.jdc.tecertaller.Service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // GET → Listar todos los comentarios
    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    // POST → Crear comentario
    @PostMapping("/crear")
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.saveComment(comment);
    }

    // PUT → Actualizar comentario
    @PutMapping("/modificar/{id}")
    public Comment updateComment(@PathVariable Long id, @RequestBody Comment comment) {
        return commentService.updateComment(id, comment);
    }

    // DELETE → Eliminar comentario
    @DeleteMapping("/eliminar/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
}
