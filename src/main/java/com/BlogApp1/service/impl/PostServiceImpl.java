package com.BlogApp1.service.impl;

import com.BlogApp1.dto.ListPostDto;
import com.BlogApp1.dto.PostDto;
import com.BlogApp1.entity.Post;
import com.BlogApp1.exception.ResourceNotFound;
import com.BlogApp1.repository.PostRepository;
import com.BlogApp1.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

     private PostRepository postRepository;
     private ModelMapper modelMapper;

    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = mapToEntity(postDto);
        Post savedPost = postRepository.save(post);
        PostDto dto  = mapToDto(savedPost);
        return dto;
    }

    @Override
    public void deletePost(long id) {

        postRepository.deleteById(id);
    }

    public PostDto getPostById(long id){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Post not found with id :"+id)
        );
        return  mapToDto(post);
        //if the object is found put the address into it,if object is not found in id then run this -> orElseThrow() ,
        //orElseThrow() it is taking a supplier(java 8 feature)(it doesn't take input it simply produce output) to throw an exception.
    }

    @Override
    public ListPostDto fetchAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                :Sort.by(sortBy).descending();
        PageRequest pageable = PageRequest.of(pageNo,pageSize, sort);//this pageable has information about pageno,pagesize and sortBy
        // List<Post> post = postRepository.findAll();
        Page<Post> all = postRepository.findAll(pageable);
        List<Post> post = all.getContent();
        List<PostDto> postDtos = post.stream().map(p -> mapToDto(p)).collect(Collectors.toList());

        ListPostDto listPostDto = new ListPostDto();
        listPostDto.setPostDto(postDtos);
        listPostDto.setTotalElements((int) all.getTotalElements());
        listPostDto.setTotalPages(all.getTotalPages());
        listPostDto.setFirstPage(all.isFirst());
        listPostDto.setLastPage(all.isLast());
        listPostDto.setPageNumber(all.getNumber());
        return listPostDto;
    }
    private Post mapToEntity(PostDto postDto) {
       /* Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        */
        //Using ModelMapper
        Post post = modelMapper.map(postDto,Post.class);
        return post;
    }
    private PostDto mapToDto(Post post) {
       /* PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());

        */
        //USING MODELMAPPER
        PostDto postDto = modelMapper.map(post,PostDto.class);
        return postDto;
    }
}
