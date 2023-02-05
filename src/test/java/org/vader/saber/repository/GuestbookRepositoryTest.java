package org.vader.saber.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.vader.saber.entity.GuestBook;

import java.util.stream.IntStream;

@SpringBootTest
public class GuestbookRepositoryTest {
    @Autowired
    private GuestbookRepository guestbookRepository;

    @Test
    public void insertDummies() {
//        IntStream.rangeClosed(1, 300).forEach(i -> {
//            GuestBook guestbook = GuestBook.builder()
//                    .title("Title..." + i)
//                    .content("Content..." + i)
//                    .writer("user" + (i % 10))
//                    .build();
//            System.out.println(guestbookRepository.save(guestbook));
//        });
    }
}
