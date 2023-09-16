package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;

//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

//import javax.xml.transform.Result;
import java.util.List;
import java.util.Optional;
import  static org.assertj.core.api.Assertions.*;
class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository=new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();

    }

    @Test
    public void save(){
        Member member = new Member();

        member.setName("spring");
        //커맨드 시프트 엔터..?
        repository.save(member);
        Member result = repository.findById(member.getId()).get();  //이 부분 어려워
        //System.out.println("result = "+ (result=member));  //여기 왜이러지
     //   Assertions.assertEquals(member, result);
        Assertions.assertThat(member).isEqualTo(result);


    }

    //다음단계로 못넘어가게

    @Test //스프링1 스프링 2라는 회원
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
//여기 실습이 안돼  9분
        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);

    }
//findnaem 오류 : 11:34, 모든 테스트는 순서와 상관 없ㅇ늠
    //dlal 여기서 스프링 1, 스프링 2가 생성됨
    @Test
    public void findAll() {
        Member member1= new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member1.setName("spring2");
        repository.save(member2);
        //단축키

         List<Member> result = repository.findAll();
         assertThat(result.size()).isEqualTo(2);
    }
}
