package com.shop.myapp.repository;

import com.shop.myapp.domain.Board2;
import com.shop.myapp.repository.Board2Repository;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class Board2RepositoryTest {

    @Autowired
    Board2Repository board2Repository;

//    @Test
//    public void testInsert(){
//        IntStream.rangeClosed(1, 10).forEach(i -> {
//            Board2 board2 = Board2.builder()
//                    .title("제목"+i)
//                    .content("더미내용"+i)
//                    .writer("user"+i)
//                    .build();
//            Board2 result = board2Repository.save(board2);
//            log.info("BNO :"+result.getBno());
//        });
//    }

//    @Test
//    public void testSelect(){
//        Long bno = 10L;
//        Optional<Board2> result = board2Repository.findById(bno);
//        Board2 board2 = result.orElseThrow();
//        log.info(board2);
//    }
//    @Test
//    public void testUpdate(){
//        Long bno = 8L;
//        Optional<Board2> result = board2Repository.findById(bno);
//        Board2 board2 = result.orElseThrow();
//        board2.change("수정제목 8번글", "8번글 수정된 내용");
//        board2Repository.save(board2);
//    }
//    @Test
//    public void testDelete(){
//        Long bno = 9L;
//        board2Repository.deleteById(bno);
//    }
    @Test
    public void testSelectAll(){
        List<Board2> list = board2Repository.findAll();
        for(Board2 board2 : list){
           log.info("POST :"+board2.toString());
        }
    }
}
