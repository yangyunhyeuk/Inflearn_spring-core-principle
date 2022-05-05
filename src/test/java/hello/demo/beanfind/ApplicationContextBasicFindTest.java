package hello.demo.beanfind;

import hello.demo.AppConfig;
import hello.demo.member.MemberService;
import hello.demo.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
//        System.out.println("memberService = " + memberService);
//        System.out.println("memberService.getClass() = " + memberService.getClass());

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
        // memberService가 MemberServiceImpl의 인스턴스면 성공
    }

    @Test
    @DisplayName("이름없이 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
        // memberService가 MemberServiceImpl의 인스턴스면 성공
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
        // memberService가 MemberServiceImpl의 인스턴스면 성공
    }
    // 개발자는 추상성에 의존해야지, 구체 타입에 의존하면 유연성이 떨어진다는 점을 참고한다.

    @Test
    @DisplayName("빈 이름으로 조회 실패")
    void findBeanByNameX() {
        // ac.getBean("noName", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("noName", MemberService.class));
    }

}
