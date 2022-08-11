package site.xddongx.boardspringboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.xddongx.boardspringboot.dto.BoardDto;
import site.xddongx.boardspringboot.servie.BoardService;

import java.util.Collection;

@RestController
@RequestMapping("api/board")
public class BoardAPIController {
    private final Logger logger = LoggerFactory.getLogger(BoardAPIController.class);
    private final BoardService boardService;

    public BoardAPIController(BoardService boardService) {
        this.boardService = boardService;
    }

    // GET
    @GetMapping()
    public ResponseEntity<Collection<BoardDto>> readBoarList() {
        return ResponseEntity.ok(this.boardService.readBoardList());
    }

    // GET
    @GetMapping("{postNo}")
    public ResponseEntity<BoardDto> readBoardOne(@PathVariable("postNo") Long postNo) {
        return ResponseEntity.ok(this.boardService.readBoardOne(postNo));
    }

    // POST
    @PostMapping()
    public ResponseEntity<BoardDto> createBoard(@RequestBody BoardDto boardDto) {
        return ResponseEntity.ok(this.boardService.createBoard(boardDto));
    }

    // PUT
    @PutMapping("{postNo}")
    public ResponseEntity<BoardDto> modifiedBoard(@PathVariable("postNo") Long postNo, @RequestBody BoardDto boardDto) {
        return ResponseEntity.ok(this.boardService.modifiedBoard(postNo, boardDto));
    }

    // DELETE
    @PutMapping("delete/{postNo}")
    public void deleteBoard(@PathVariable("postNo") Long postNo) {
        this.boardService.deleteBoard(postNo);
    }
}
