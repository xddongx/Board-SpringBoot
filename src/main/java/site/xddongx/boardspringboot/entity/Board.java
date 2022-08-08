package site.xddongx.boardspringboot.entity;

import lombok.Getter;
import lombok.Setter;
import site.xddongx.boardspringboot.util.Timestamp;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Board extends Timestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postNo;

    private String title;
    private String content;
    private boolean isDelete = false;
}
