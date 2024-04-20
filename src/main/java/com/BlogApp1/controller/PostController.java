package com.BlogApp1.controller;

import com.BlogApp1.dto.ListPostDto;
import com.BlogApp1.dto.PostDto;
import com.BlogApp1.service.PostService;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    //http://localhost:8080/api/posts
    @PostMapping
    public ResponseEntity<?> createPost(@Valid @RequestBody PostDto postDto, BindingResult bindingResult){
    if (bindingResult.hasErrors()){
        return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    //http://localhost:8080/api/posts/2
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable long id){
        postService.deletePost(id);
        return new ResponseEntity<>("Post Deleted successfully!!",HttpStatus.OK);
    }

    @GetMapping
    //@GetMapping should interact with Service layer
   // public ResponseEntity<List<PostDto>> fetchAllPosts(){
      //  List<PostDto> postDtos = postService.fetchAllPosts();
        //return new ResponseEntity<>(postDtos,HttpStatus.OK);

        //http://localhost:8080/api/posts?pageNo=0&pageSize=5
        //+++++++++++++++PAGINATION++++++++++++++++++++++

//        public ResponseEntity<List<PostDto>> fetchAllPosts(
//                @RequestParam(name = "pageNo",defaultValue = "0",required = false)int pageNo,
//                @RequestParam(name ="pageSize",defaultValue = "0",required = false)int pageSize
//                ){
//            List<PostDto> postDtos = postService.fetchAllPosts(pageNo,pageSize);
//            return new ResponseEntity<>(postDtos,HttpStatus.OK);
//        }

    //http://localhost:8080/api/posts?pageNo=0&pageSize=5&SortBy=description
    //-------------------------PAGINATION AND SORTING(Sorting by asc and dsc)-----------------------------

            public ListPostDto fetchAllPosts(
                @RequestParam(name = "pageNo",defaultValue = "0",required = false)int pageNo,
                @RequestParam(name ="pageSize",defaultValue = "0",required = false)int pageSize,
                @RequestParam(name ="sortBy",defaultValue = "id",required = false)String sortBy,
                @RequestParam(name ="sortDir",defaultValue = "asc",required = false)String sortDir
                ){
            ListPostDto listPostDto = postService.fetchAllPosts(pageNo,pageSize,sortBy,sortDir);
            return listPostDto;
        }
        //http://localhost:8080/api/posts?id=1
        @GetMapping("/{id}")
        public ResponseEntity<PostDto> getPostById(@PathVariable long id){
        PostDto dto = postService.getPostById(id);
        return  new ResponseEntity<>(dto,HttpStatus.OK);
        }
    }
