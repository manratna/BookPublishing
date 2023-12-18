package com.bp.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TitleAuthorDTO {
	
    private Long id;

    @NotNull(message = "Author information is required")
    @Valid
    private AuthorDTO author;

    @NotNull(message = "Title information is required")
    @Valid
    private TitleDTO title;

    @Positive(message = "Royalty percentage should be a positive integer")
    private Integer royaltyPer;

}
