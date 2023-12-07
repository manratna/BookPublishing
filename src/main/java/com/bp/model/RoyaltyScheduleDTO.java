package com.bp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoyaltyScheduleDTO {
    private Long id;
    private TitleDTO title;
    private Integer lowRange;
    private Integer highRange;
    private Integer royalty;
}

