package sj.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sj.board.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
