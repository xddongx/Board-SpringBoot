package site.xddongx.boardspringboot.entity;

import lombok.Getter;
import lombok.Setter;
import site.xddongx.boardspringboot.util.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Board extends Timestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postNo;

    private String title;
    private String content;
}
