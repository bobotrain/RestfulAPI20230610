package com.restapi.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestAPI {

    private List<Book> bookList = new ArrayList<>();

    @RequestMapping(method = RequestMethod.GET, path="/books")
    public List<Book> GetAll(){
        return bookList;
    }
    @RequestMapping(method = RequestMethod.POST, path="/add")
    public String Add(@RequestBody Book book){ // Book 클래스를 참조한다는 뜻. -> book 객체로 다룰 예정.
        bookList.add(book); // 만든 북 객체를 북 리스트에 담으면 끝
        return "Add";
    }
    @RequestMapping(method = RequestMethod.PUT, path="/update/{id}")
    public String Update(@RequestBody Book tobook, @PathVariable int id){
        Book find_book = bookList.stream()
                .filter(book-> book.getId() == id)
                .findAny()
                .orElse(null);

        if(find_book != null){
            //해당 id찾으면 name,author,price 바꿔줘라
            //우리가 json방식으로 보냈던 tobook내용대로...
            find_book.setAuthor(tobook.getAuthor());
            find_book.setName(tobook.getName());
            find_book.setPrice(tobook.getPrice());

            return "success";
        }
        return "not valid";

    }
    @RequestMapping(method = RequestMethod.DELETE, path="/delete/{id}")
    public String Delete(@PathVariable int id){

        Book find_book = bookList.stream()
                //하나씩 읽으면서 bookId에 해당 id가 있는지확인
                .filter(book -> book.getId() == id)
                //만약 있다면 한개에 대한 책 객체를 가져올꺼임
                .findAny()
                //없다면 null을 리턴함
                .orElse (null);

        //책 발견했을 때 삭제
        if(find_book!= null){
            bookList.remove(find_book);
            return "success";
        }
        //삭제 안했다~
        return "not valid";
    }
}
