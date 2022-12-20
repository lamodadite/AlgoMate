package jongmin.AlgoMate.util.auth;

import jongmin.AlgoMate.model.member.Member;

public class MemberContext {
    public static ThreadLocal<Member> currentMember = new ThreadLocal<>();
}
