package com.themechguy.blogapp.payloads;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {
    private Long id;
    @Size(min=4,max=100,message="Title must range between 4 to 100 characters")
    private String title;
    @Size(min=10, message="Cannot be less than 10 characters")
    private String description;
    
}
