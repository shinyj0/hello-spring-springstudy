package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;
import java.util.Optional;

public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence = 0L;




    @Override
    public Member save(Member member) {
        member.setId(++sequence);  //아이디 셋팅
        store.put(member.getId(),member);
        return member;

    }

    @Override
    public Optional<Member> findById(Long id) {
       // return Optional.ofNullable(store.get(id));//널이어도 감씰수 있음
        return  Optional.ofNullable(store.get(id));  //null어도 감쌀수 있음
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member->member.getName().equals(name))
                .findAny();  //하나로도 찾는거, 루프를 돌으며 하나를 찾으면 반환
    }

    @Override  //테스트개횟거
    //리스트 많이씀
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //이 values가 반환
    }
    public void clearStore(){
        store.clear();

    }
}