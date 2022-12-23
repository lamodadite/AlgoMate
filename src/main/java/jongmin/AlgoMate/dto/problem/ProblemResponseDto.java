package jongmin.AlgoMate.dto.problem;

import jongmin.AlgoMate.model.problem.ProblemTag;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProblemResponseDto {

    private Long id;

    private String title;

    private String link;

    private String content;

    private int difficulty;

    private LocalDateTime notificationDate;

    private List<ProblemTag> tagList;
}
