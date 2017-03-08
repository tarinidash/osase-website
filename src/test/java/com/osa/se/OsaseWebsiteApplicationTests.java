package com.osa.se;

import com.icegreen.greenmail.junit.GreenMailRule;
import com.icegreen.greenmail.util.ServerSetupTest;
import com.osa.se.fixture.*;
import com.osa.se.model.*;
import com.osa.se.service.*;
import org.h2.tools.Server;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class OsaseWebsiteApplicationTests {

    private static Server h2Webserver;
    private static Server h2Tcpserver;

    @Rule
    public final GreenMailRule greenMail = new GreenMailRule(ServerSetupTest.ALL);

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
    @Autowired
    private NotificationService notificationService;

    /**
     * Sets up before all the tests are run.
     *
     * @throws SQLException the sql exception
     */

    @BeforeClass
    public static void setUp() throws SQLException {
        h2Webserver = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8083").start();
        h2Tcpserver = Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9083").start();
    }

    /**
     * Cleans up after all the tests are run.
     */
    @AfterClass
    public static void cleanUp() {
        h2Webserver.stop();
        h2Tcpserver.stop();
    }

    @Test
    public void contextLoads() throws Exception {

        // save/create  event

        Event event = EventFixture.getEvent();
        eventService.save(event);

        Event event1 = EventFixture.getEvent1();
        eventService.save(event1);

        // save/create notification

        Notification notification = NotificationFixture.getNotification();
        notification.setEvent(event);
        notificationService.save(notification);

        Notification notification1 = NotificationFixture.getNotification1();
        notification1.setEvent(event1);
        notificationService.save(notification1);

        // save/create ledger

        Ledger ledger =  LedgerFixture.getLedger();
        ledger.setEvent(event);
        ledgerService.save(ledger);

        Ledger ledger1 =  LedgerFixture.getLedger1();
        ledger1.setEvent(event);
        ledgerService.save(ledger1);

        Ledger ledger2 =  LedgerFixture.getLedger2();
        ledger2.setEvent(event);
        ledgerService.save(ledger2);

        Ledger ledger3 =  LedgerFixture.getLedger3();
        ledger3.setEvent(event);
        ledgerService.save(ledger3);

        Ledger ledger4 =  LedgerFixture.getLedger4();
        ledger4.setEvent(event);
        ledgerService.save(ledger4);

        Ledger ledger5 =  LedgerFixture.getLedger5();
        ledger5.setEvent(event1);
        ledgerService.save(ledger5);

        Ledger ledger6 =  LedgerFixture.getLedger6();
        ledger6.setEvent(event1);
        ledgerService.save(ledger6);

        Ledger ledger7 =  LedgerFixture.getLedger7();
        ledger7.setEvent(event1);
        ledgerService.save(ledger7);

        Ledger ledger8 =  LedgerFixture.getLedger8();
        ledger8.setEvent(event1);
        ledgerService.save(ledger8);


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
        payment.setEvent(event);
        paymentService.save(payment);

        Payment payment1 = PaymentFixture.getPayment1();
        payment1.setFamily(family);
        payment1.setEvent(event);
        paymentService.save(payment1);

        Payment payment2 = PaymentFixture.getPayment2();
        payment2.setFamily(family);
        payment2.setEvent(event1);
        paymentService.save(payment2);

        assertThat(paymentService.count(), equalTo(3L));

//        Thread.sleep(20000000L);
    }

}
