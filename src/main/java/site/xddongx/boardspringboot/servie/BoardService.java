package site.xddongx.boardspringboot.servie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import site.xddongx.boardspringboot.dto.BoardDto;
import site.xddongx.boardspringboot.entity.Board;
import site.xddongx.boardspringboot.repository.BoardRepository;

@Service
public class BoardService {
    private final Logger logger = LoggerFactory.getLogger(BoardService.class);
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public BoardDto createBoard(BoardDto boardDto) {

        String newTitle = boardDto.getTitle();
        String newContent = boardDto.getContent();

        Board newBoard = new Board();
        newBoard.setTitle(newTitle);
        newBoard.setContent(newContent);

        this.boardRepository.save(newBoard);

        return new BoardDto(newBoard);
    }
}
