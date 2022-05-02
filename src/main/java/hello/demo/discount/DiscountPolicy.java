package hello.demo.discount;

import hello.demo.member.Member;

public interface DiscountPolicy {


    int discount(Member member, int price);
}
