package site.xddongx.boardspringboot.servie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import site.xddongx.boardspringboot.dto.BoardDto;
import site.xddongx.boardspringboot.entity.Board;
import site.xddongx.boardspringboot.repository.BoardRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<BoardDto> readBoardList() {
        List<BoardDto> boardDtoList = new ArrayList<>();
        boardRepository.findAll().stream().filter(board -> !board.isDelete()).forEach(board -> boardDtoList.add(new BoardDto(board)));

        return boardDtoList;
    }

    public BoardDto readBoardOne(Long postNo) {
        Optional<Board> targetBoard = boardRepository.findById(postNo).filter(board -> !board.isDelete());
        if (targetBoard.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return new BoardDto(targetBoard.get());
    }

    public BoardDto modifiedBoard(Long postNo, BoardDto boardDto) {
        Optional<Board> targetBoard = boardRepository.findById(postNo).filter(board -> !board.isDelete());

        if(targetBoard.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Board board = targetBoard.get();
        board.modifiedBoard(boardDto);

        boardRepository.save(board);
        return new BoardDto(board);
    }

    public void deleteBoard(Long postNo) {
        Optional<Board> targetBoard = boardRepository.findById(postNo).filter(board -> !board.isDelete());

        if (targetBoard.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Board board = targetBoard.get();
        board.setDelete(true);
        boardRepository.save(board);
    }
}
