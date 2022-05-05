package hello.demo;

import hello.demo.member.Grade;
import hello.demo.member.Member;
import hello.demo.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);


        // MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "james", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("member : " + member.getName());
        System.out.println("findMember : " + findMember.getName());

    }
}
