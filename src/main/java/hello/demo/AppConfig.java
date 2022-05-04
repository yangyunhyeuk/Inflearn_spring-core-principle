package hello.demo;

import hello.demo.discount.DiscountPolicy;
import hello.demo.discount.FixDiscountPolicy;
import hello.demo.discount.RateDiscountPolicy;
import hello.demo.member.MemberService;
import hello.demo.member.MemberServiceImpl;
import hello.demo.member.MemoryMemberRepository;
import hello.demo.order.OrderService;
import hello.demo.order.OrderServiceImpl;

// AppConfig : 어플리케이션의 실제 동작에 필요한 구현 객체를 생성하는 클래스
// AppConfig : 생성한 객체 인스턴스의 참조를 '생성자를 통해서 주입(연결)'해준다.
public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(MemberRepository());
    }

    private MemoryMemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(MemberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
        // return new FixDiscountPolicy();
    }
}
