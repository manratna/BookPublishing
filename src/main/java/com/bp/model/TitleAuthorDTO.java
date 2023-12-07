package com.bp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TitleAuthorDTO {
    private Long id;
    private AuthorDTO author;
    private TitleDTO title;
    private Integer auOrd;
    private Integer royaltyPer;
}

