package com.ssafy.trip.controller;


import com.ssafy.trip.Entity.Attraction;
import com.ssafy.trip.service.AttractionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/attraction")
public class AttractionController {

    @Autowired
    private AttractionService attractionService;

    @GetMapping("/search-list")
    public ResponseEntity<?> selectByKeyword(
            @PageableDefault(size = 15) Pageable pageable,
            @RequestParam(value = "sidoCode",required = false) Integer sidoCode,
            @RequestParam(value = "contentTypeId", required = false) Integer contentTypeId,
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "contentId", required = false) Integer contentId
    ){

        Page<Attraction> attractions = attractionService.getAttractions(pageable,sidoCode,contentTypeId,keyword, contentId);

        return new ResponseEntity<>(attractions,HttpStatus.OK);

    }
//
//    @PostMapping("/{attraction_id}/like")
//    public ResponseEntity<?> likeAttraction(
//            @PathVariable Integer attraction_id,
//            HttpSession session
//    ){
//        String userId = session.getId();
//        boolean check = false;
//
//        if(userId != null || !userId.isEmpty()){
//            check = attractionService.attractionLike(userId,attraction_id);
//        }
//
//        return check ? new ResponseEntity<>(HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }

}
