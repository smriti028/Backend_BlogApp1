package com.BlogApp1.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {

    private long id;
    @NotEmpty
    @Size(min = 3, message = "Title should be at least 3 characters")
    private String title;
    private String description;
    private String content;
}
