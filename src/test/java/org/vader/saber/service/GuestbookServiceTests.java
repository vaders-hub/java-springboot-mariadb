package org.vader.saber.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.vader.saber.dto.GuestbookDTO;
import org.vader.saber.dto.PageRequestDTO;
import org.vader.saber.dto.PageResultDTO;
import org.vader.saber.entity.Guestbook;
import org.vader.saber.repository.GuestbookRepository;

import java.util.stream.IntStream;

@SpringBootTest
public class GuestbookServiceTests {
    @Autowired
    private GuestbookService service;
    @Autowired
    private GuestbookRepository guestbookRepository;

    @Test
    public void insertDummies() {
        IntStream.rangeClosed(1, 300).forEach(i -> {

            Guestbook guestbook = Guestbook.builder()
                    .title("title...." + i)
                    .content("Content...." + i)
                    .writer("User" + (i % 10))
                    .build();

            guestbookRepository.save(guestbook);
        });
    }

    @Test
    public void testRegister() {
        GuestbookDTO guestbookDTO = GuestbookDTO.builder()
                .title("Sample Title")
                .content("Sample content")
                .writer("User")
                .build();

        System.out.println(service.register(guestbookDTO));
    }

    @Test
    public void testList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();
        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.getList(pageRequestDTO);

        System.out.println("PREV: " + resultDTO.isPrev());
        System.out.println("NEXT: " + resultDTO.isNext());
        System.out.println("TOTAL: " + resultDTO.getTotalPage());

        for (GuestbookDTO guestbookDTO : resultDTO.getDtoList()) {
            System.out.println("guestbookDTO >>>>" + guestbookDTO);
        }
        
        resultDTO.getPageList().forEach(i -> System.out.println("Page List >>>>" + i));
    }
}
