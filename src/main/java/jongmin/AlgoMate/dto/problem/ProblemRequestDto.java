package jongmin.AlgoMate.dto.problem;


import jongmin.AlgoMate.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ProblemRequestDto {

    @NotBlank
    private String title;

    @NotNull
    private String link;

    @NotNull
    private int difficulty;

    @NotBlank
    private String content;

    @NotNull
    private LocalDateTime notificationDate;

    @NotNull @Valid
    private List<String> tagList;
}
