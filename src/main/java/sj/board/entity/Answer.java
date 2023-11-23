package sj.board.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @CreatedDate
    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    @ManyToOne
    private Question question;

    public Answer() {
    }

    public Answer(String content) {
        this.content = content;
        this.createDate = LocalDateTime.now();
    }

    @ManyToOne
    private SiteUser author;

    @ManyToMany
    Set<SiteUser> voter;
}