package com.example.dao;


import com.example.model.Member;
import org.springframework.data.repository.RepositoryDefinition;


@RepositoryDefinition(domainClass = Member.class, idClass = Long.class)
public interface MemberDao2 /*extends MyCustomDao<Member,Long> */ {
void save(Member member);
}
