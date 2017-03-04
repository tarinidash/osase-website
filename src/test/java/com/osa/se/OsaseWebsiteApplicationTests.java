package com.osa.se;

import com.osa.se.fixture.*;
import com.osa.se.model.Family;
import com.osa.se.model.Member;
import com.osa.se.model.Payment;
import com.osa.se.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OsaseWebsiteApplicationTests {

    //    private static Server h2Webserver;
//    private static Server h2Tcpserver;
    @Autowired
    private EventService eventService;
    @Autowired
    private FamilyService familyService;
    @Autowired
    private LedgerService ledgerService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private PaymentService paymentService;

    /**
     * Sets up before all the tests are run.
     *
     * @throws SQLException the sql exception
     */
//    @BeforeClass
//    public static void setUp() throws SQLException {
//        h2Webserver = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082").start();
//        h2Tcpserver = Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9082").start();
//    }

    /**
     * Cleans up after all the tests are run.
     */
//    @AfterClass
//    public static void cleanUp() {
//        h2Webserver.stop();
//        h2Tcpserver.stop();
//    }
    @Test
    public void contextLoads() throws Exception {
        eventService.save(EventFixture.getEvent());
        eventService.save(EventFixture.getEvent1());

        ledgerService.save(LedgerFixture.getLedger());
        ledgerService.save(LedgerFixture.getLedger1());
        ledgerService.save(LedgerFixture.getLedger2());
        ledgerService.save(LedgerFixture.getLedger3());
        ledgerService.save(LedgerFixture.getLedger4());
        ledgerService.save(LedgerFixture.getLedger5());
        ledgerService.save(LedgerFixture.getLedger6());
        ledgerService.save(LedgerFixture.getLedger7());
        ledgerService.save(LedgerFixture.getLedger8());
        assertThat(ledgerService.count(), equalTo(9L));
        assertThat(ledgerService.findLast().getBalance(), equalTo(new BigDecimal(-110.43).setScale(2, RoundingMode.CEILING)));

        Family family = FamilyFixture.getFamily();
        familyService.save(family);
        assertThat(familyService.count(), equalTo(1L));

        Member member = MemberFixture.getMember();
        member.setFamily(family);
        memberService.save(member);

        Member member1 = MemberFixture.getMember1();
        member1.setFamily(family);
        memberService.save(member1);

        Member member2 = MemberFixture.getMember2();
        member2.setFamily(family);
        memberService.save(member2);
        assertThat(memberService.count(), equalTo(3L));

        Payment payment = PaymentFixture.getPayment();
        payment.setFamily(family);
        paymentService.save(payment);

        Payment payment1 = PaymentFixture.getPayment1();
        payment1.setFamily(family);
        paymentService.save(payment1);

        Payment payment2 = PaymentFixture.getPayment2();
        payment2.setFamily(family);
        paymentService.save(payment2);
        assertThat(paymentService.count(), equalTo(3L));

//        Thread.sleep(20000000L);
    }

}
