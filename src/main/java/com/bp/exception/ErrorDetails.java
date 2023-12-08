package com.bp.exception; 
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ErrorDetails {
 
	private LocalDate dateTime;
	private String string;

	@Override
	public String toString() {
		return "ErrorDetails [dateTime=" + dateTime + ", string=" + string + "]";
	}



}
