package pl.furmanj.oiw.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.furmanj.oiw.model.Note;



import java.util.List;

//Inicjowanie bazy danych
@Repository
public interface NoteRepo extends JpaRepository<Note, Long> {

    Note findAllById(Long id);

    List<Note> findAllByCategoriesContains(String name);
}


