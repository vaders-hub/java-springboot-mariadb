package org.vader.saber.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.vader.saber.entity.Memo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootTest
public class MemoRepositoryTests {
    @Autowired
    MemoRepository memoRepository;

    @Test
    public void testQueryMethod() {
//        List<Memo> list = memoRepository.findByMnoBetweenOrderByMnoDesc(70L, 80L);
        Pageable pageable = PageRequest.of(1, 10, Sort.by("mno").descending());
        Page<Memo> result = memoRepository.findByMnoBetween(10L, 50L, pageable);

//        for (Memo memo : list) {
//            System.out.println(memo);
//        }
        result.get().forEach(memo -> System.out.println(memo));
    }
}
