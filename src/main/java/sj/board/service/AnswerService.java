package sj.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sj.board.entity.Answer;
import sj.board.entity.Question;
import sj.board.repository.AnswerRepository;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;


    public void create(Question question, String content) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        this.answerRepository.save(answer);
    }
}