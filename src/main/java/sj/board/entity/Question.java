package sj.board.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    // columnDefinition은 컬럼의 속성을 정의할 때 사용한다.
    // columnDefinition = "TEXT"은 글자 수를 제한할 수 없는 경우에 사용한다.
    @Column(columnDefinition = "TEXT")
    private String content;

    @CreatedDate
    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    // cascade : 질문을 삭제하면 그에 달린 답변들도 모두 함께 삭제하기 위함
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

    public Question() {
    }

    public Question(String subject, String content) {
        this.subject = subject;
        this.content = content;
        this.createDate = LocalDateTime.now();
    }

    @ManyToOne
    private SiteUser author;

    @ManyToMany
    Set<SiteUser> voter;
}