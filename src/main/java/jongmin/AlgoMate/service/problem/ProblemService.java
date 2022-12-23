package jongmin.AlgoMate.service.problem;

import jongmin.AlgoMate.dto.problem.ProblemRequestDto;
import jongmin.AlgoMate.model.member.Member;
import jongmin.AlgoMate.model.problem.Problem;
import jongmin.AlgoMate.model.problem.ProblemTag;
import jongmin.AlgoMate.model.problem.Tag;
import jongmin.AlgoMate.repository.ProblemRepository;
import jongmin.AlgoMate.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProblemService {

    private final TagRepository tagRepository;
    private final ProblemRepository problemRepository;

    @Transactional
    public Long registerProblem(Member member, ProblemRequestDto requestDto) {

        Problem problem = Problem.builder()
                .writer(member)
                .title(requestDto.getTitle())
                .link(requestDto.getLink())
                .difficulty(requestDto.getDifficulty())
                .notificationDate(requestDto.getNotificationDate())
                .build();

        List<ProblemTag> tags = requestDto.getTagList().stream()
                .map(tagName -> tagRepository.findByTagName(tagName)
                        .map(tag -> new ProblemTag(problem, tag)).orElseGet(
                                () -> new ProblemTag(problem, new Tag(tagName))
                        )).collect(Collectors.toList());

        problem.setTagList(tags);

        problemRepository.save(problem);

        return problem.getId();
    }
}
