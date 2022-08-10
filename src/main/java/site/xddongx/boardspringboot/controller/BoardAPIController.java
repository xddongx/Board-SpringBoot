package site.xddongx.boardspringboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.xddongx.boardspringboot.dto.BoardDto;
import site.xddongx.boardspringboot.entity.Message;
import site.xddongx.boardspringboot.entity.StatusEnum;
import site.xddongx.boardspringboot.servie.BoardService;

import java.nio.charset.Charset;
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
    public ResponseEntity<Message> readBoardOne(@PathVariable("postNo") Long postNo) {
        BoardDto boardDto = this.boardService.readBoardOne(postNo);

        if (boardDto == null) {
            Message message = new Message();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

            message.setStatus(StatusEnum.NOT_FOUND);
            message.setMessage("fail");
            message.setData(null);

            return new ResponseEntity<>(message, headers, HttpStatus.NOT_FOUND);
        }

        Message message = new Message();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        message.setStatus(StatusEnum.OK);
        message.setMessage("success");
        message.setData(boardDto);

        return new ResponseEntity<>(message, headers, HttpStatus.OK);
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
