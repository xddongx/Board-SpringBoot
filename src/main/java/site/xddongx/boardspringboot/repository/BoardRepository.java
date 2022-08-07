package site.xddongx.boardspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.xddongx.boardspringboot.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
