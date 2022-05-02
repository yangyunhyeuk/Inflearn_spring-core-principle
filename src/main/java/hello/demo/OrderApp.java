package hello.demo;

import hello.demo.member.Grade;
import hello.demo.member.Member;
import hello.demo.member.MemberService;
import hello.demo.member.MemberServiceImpl;
import hello.demo.order.Order;
import hello.demo.order.OrderService;
import hello.demo.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl(memberRepository, discountPolicy);

        Long memberId = 1L;
        Member member = new Member(memberId, "nameee", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "coke", 10000);

        System.out.println("order : " + order);
        // System.out.println("orderCalculate : " + order.calculatePrice());
    }
}