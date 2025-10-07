package com.jdc.tecertaller.Rest;

import com.jdc.tecertaller.Entities.Tag;
import com.jdc.tecertaller.Service.TagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagController {
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    // GET → Listar todos los tags
    @GetMapping
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }

    // POST → Crear un tag
    @PostMapping
    public Tag createTag(@RequestBody Tag tag) {
        return tagService.saveTag(tag);
    }

    // PUT → Actualizar un tag
    @PutMapping("/{id}")
    public Tag updateTag(@PathVariable Long id, @RequestBody Tag tag) {
        return tagService.updateTag(id, tag);
    }

    // DELETE → Eliminar un tag
    @DeleteMapping("/{id}")
    public void deleteTag(@PathVariable Long id) {
        tagService.deleteTag(id);
    }
}
