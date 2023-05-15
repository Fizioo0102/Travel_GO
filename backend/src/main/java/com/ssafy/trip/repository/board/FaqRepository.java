package com.ssafy.trip.repository.board;

import com.ssafy.trip.Entity.Faq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface FaqRepository extends JpaRepository<Faq, Integer> {

    // 게시판 내용 삽입
    @Transactional
    @Modifying
    @Query(value = "insert into faq (user_id, title, content) values (:user_id, :title, :content)", nativeQuery = true)
    void registCar(@Param("user_id") String user_id,
                   @Param("title") String title,
                   @Param("content") String content);

    // 게시판 상세정보 조회
    @Query(value = "select id, user_id, title, content, hit, register_time from faq where id = :id", nativeQuery = true)
    Faq getArticle(@Param("id") int id);

    // 게시판 내용 삭제
    @Transactional
    @Modifying
    @Query(value = "delete from faq where id = :id", nativeQuery = true)
    void deleteArticle(@Param("id") int id);

    // 게시판 조회수 업데이트 관련
    @Transactional
    @Modifying
    @Query(value = "update faq set hit = hit + 1 where id = :id", nativeQuery = true)
    void updateHit(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "update faq set title = :title, content = :content where id = :id", nativeQuery = true)
    void modifyArticle(
            @Param("id") int id,
            @Param("title") String title,
            @Param("content") String content);
}
