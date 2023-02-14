package org.vader.saber;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.vader.saber.entity.Guestbook;
import org.vader.saber.repository.GuestbookRepository;

import java.util.stream.IntStream;

@SpringBootTest
class SaberApplicationTests {

	@Autowired
	private GuestbookRepository guestbookRepository;

	@Test
	public void insertDummies() {

		IntStream.rangeClosed(1, 300).forEach(i -> {
			Guestbook guestbook = Guestbook.builder()
					.title("Title..." + i)
					.content("Content..." + i)
					.writer("User" + i)
					.build();
			System.out.println(guestbookRepository.save(guestbook));
		});

	}

}
