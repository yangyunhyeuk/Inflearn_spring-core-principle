package hello.demo;

import hello.demo.member.Grade;
import hello.demo.member.Member;
import hello.demo.member.MemberService;
import hello.demo.order.Order;
import hello.demo.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);


        Long memberId = 1L;
        Member member = new Member(memberId, "nameee", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "coke", 20000);

        System.out.println("order : " + order);
        // System.out.println("orderCalculate : " + order.calculatePrice());
    }
}
