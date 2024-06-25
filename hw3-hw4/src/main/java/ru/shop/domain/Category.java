package ru.shop.domain;

import com.ibm.icu.text.Transliterator;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "categories")
public class Category {

    @jakarta.persistence.Id
    @Id
    private UUID id;
    @Column(unique = true)    @NotNull
    private String name;
    @NotNull
    private String url;
    public Category() {}

    public Category(String name) {
        this.id = UUID.randomUUID();
        this.name = name;

        String CYRILLIC_TO_LATIN = "Russian-Latin/BGN";

        Transliterator toLatinTrans = Transliterator.getInstance(CYRILLIC_TO_LATIN);
        this.url = toLatinTrans.transliterate(name.toLowerCase().replace(" ", "_"));

    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
