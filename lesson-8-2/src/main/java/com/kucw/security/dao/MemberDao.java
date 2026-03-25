package com.kucw.security.dao;

import java.util.List;
import com.kucw.security.model.Member;
import com.kucw.security.model.Role;

public interface MemberDao {

    // 基本 Member 操作
    Member getMemberByEmail(String email);

    Integer createMember(Member member);

    List<Role> getRolesByMemberId(Integer memberId);

    void addRoleForMemberId(Integer memberId, Role role);

}
