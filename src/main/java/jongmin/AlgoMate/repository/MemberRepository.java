package jongmin.AlgoMate.repository;

import jongmin.AlgoMate.model.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    // select * from member where name = ?
    Member findByEmail(String email);

    Member findByName(String name);
}
