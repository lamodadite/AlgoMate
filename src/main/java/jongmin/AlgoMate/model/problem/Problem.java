package jongmin.AlgoMate.model.problem;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jongmin.AlgoMate.model.BaseEntity;
import jongmin.AlgoMate.model.member.Member;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
@Entity
public class Problem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "problem_id", updatable = false)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "member_id", updatable = false)
    private Member writer;

    private String title;

    private String link;

    private int difficulty;

    private String content;

    private LocalDateTime notificationDate;

    @JsonIgnore
    @OneToMany(mappedBy = "problem", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProblemTag> tagList = new ArrayList<>();

    public void setTagList(List<ProblemTag> tagList) {
        this.tagList = tagList;
    }
}
