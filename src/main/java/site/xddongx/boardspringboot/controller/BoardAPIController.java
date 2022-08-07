package site.xddongx.boardspringboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.xddongx.boardspringboot.dto.BoardDto;
import site.xddongx.boardspringboot.servie.BoardService;

@RestController
@RequestMapping("api")
public class BoardAPIController {
    private final Logger logger = LoggerFactory.getLogger(BoardAPIController.class);
    private final BoardService boardService;

    public BoardAPIController(BoardService boardService) {
        this.boardService = boardService;
    }

    // GET

    // GET

    // POST
    @PostMapping("board")
    public ResponseEntity<BoardDto> createBaord(@RequestBody BoardDto boardDto) {
        return ResponseEntity.ok(this.boardService.createBoard(boardDto));
    }
    // PUT

    // DELETE

}
