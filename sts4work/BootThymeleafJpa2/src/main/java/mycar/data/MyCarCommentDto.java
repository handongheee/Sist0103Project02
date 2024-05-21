package mycar.data;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // 디폴트 생성자
@AllArgsConstructor
@Builder
@Entity
@Table(name="mycar_comment")
public class MyCarCommentDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idx;
	
	@ManyToOne
	@JoinColumn(name = "num")
	@OnDelete(action = OnDeleteAction.CASCADE) // 부모데이터 지우면 댓글 삭제
	private MyCarDto mycar;
	
	@Column
	private String comment;
	
	@Column(updatable = false) // 수정 안되게
	@CreationTimestamp // 생성 시 자동
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm") // 패턴 지정
	private Timestamp writeday;

}
