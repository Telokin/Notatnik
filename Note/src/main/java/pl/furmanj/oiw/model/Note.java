package pl.furmanj.oiw.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Inicjowanie zapisu do bazy danych
@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String text;
    private String categories;

    public Note() {
    }

    public Note(String title, String author, String text, String categories) {
        this.title = title;
        this.author = author;
        this.text = text;
        this.categories=categories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public String getCategories() {
        return this.categories;
    }

    public List<String> getListCategories(String s) {
        return getListHashtags(this.categories);
    }

    public void setCategories(String categories) {
        this.categories=getHashtags(categories);
    }

    //Nadpisywanie adnotacji
    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", categories='" + categories + '\'' +
                '}';
    }

    //Tworzenie hasel do wyszukiwania
    public static String getHashtags(String s){
        String out = "";
        if (s != null) {
            Pattern pattern = Pattern.compile("(#[A-Za-z0-9-_]+)");
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                out = out.concat(matcher.group(0));
            }
        }
        return out;
    }

    //Umieszczanie hasel do wyszukiwania w liscie
    private List<String> getListHashtags(String s){
        List<String> out = new ArrayList<>();
        if (s != null) {
            Pattern pattern = Pattern.compile("(#[A-Za-z0-9-_]+)");
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                out.add(matcher.group(0));
            }
        }
        return out;
    }
}