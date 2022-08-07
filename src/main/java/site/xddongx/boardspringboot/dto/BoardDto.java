package site.xddongx.boardspringboot.dto;

import lombok.Getter;
import lombok.Setter;
import site.xddongx.boardspringboot.entity.Board;

@Getter
@Setter
public class BoardDto {
    private String title;
    private String content;

    public BoardDto() {
    }

    public BoardDto(Board board) {
        this.title = board.getTitle();
        this.content = board.getTitle();
    }
}
