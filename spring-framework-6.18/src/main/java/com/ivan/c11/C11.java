package com.ivan.c11;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

public class C11 {

    static final String path = "D:\\ivan-project\\Practice\\spring-framework-6.18\\src\\main\\java\\com\\ivan\\c11\\c11.xml";
    public static void main(String[] args) {
        test1();

    }

    private static void test1() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("file:"+ path);
        EmailService em = context.getBean(EmailService.class);
        em.sendEmail("known.spammer@example.org", "test");
    }
}

//事件实体
class BlockedListEvent extends ApplicationEvent {
    final String address;
    final String content;
    public BlockedListEvent(Object source, String address, String content) {
        super(source);
        this.address = address;
        this.content = content;
    }
}
// 事件发布
class EmailService implements ApplicationEventPublisherAware {

    List<String> blockedList;
    ApplicationEventPublisher publisher;

    public void setBlockedList(List<String> blockedList) {
        this.blockedList = blockedList;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
    public void sendEmail(String address, String content) {
        if (blockedList.contains(address)) {
            publisher.publishEvent(new BlockedListEvent(this, address, content));
        }
        // sendEmail logic
    }
}
class BlockedListNotifier implements ApplicationListener<BlockedListEvent> {
    String notificationAddress;

    public BlockedListNotifier() {
        System.out.println("notifier constructor");
    }

    public void setNotificationAddress(String notificationAddress) {
        this.notificationAddress = notificationAddress;
    }
    @Override
    public void onApplicationEvent(BlockedListEvent event) {
        // notify appropriate parties via notificationAddress..
        System.out.println("BlockedListNotifier: " + event.address + " " + event.content);
    }
}




