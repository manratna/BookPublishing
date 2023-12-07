package com.bp.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roy_sched")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoyaltySchedule {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @ManyToOne
    @JoinColumn(name = "title_id")
    private Title title;

    @Column(name = "lorange")
    private Integer lowRange;

    @Column(name = "hirange")
    private Integer highRange;

    @Column(name = "royalty")
    private Integer royalty;

}
