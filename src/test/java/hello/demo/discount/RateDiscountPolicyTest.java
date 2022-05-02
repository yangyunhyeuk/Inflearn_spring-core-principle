package hello.demo.discount;

import hello.demo.member.Grade;
import hello.demo.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("vip는 10% 할인이 적용되어야 한다. ")
    void vip_o() {
        // given
        Member member = new Member(1L, "vipMember", Grade.VIP);

        // when
        int discount = discountPolicy.discount(member, 10000);

        // then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("vip가 아닐 경우 10% 할인이 적용되지 않아야 한다. ")
    void vip_x() {
        // given
        Member member = new Member(2L, "basicMember", Grade.BASIC);

        // when
        int discount = discountPolicy.discount(member, 10000);

        // then
        Assertions.assertThat(discount).isEqualTo(0);
    }

}