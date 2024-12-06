package ch15.sec02.exam01;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date date;
}
