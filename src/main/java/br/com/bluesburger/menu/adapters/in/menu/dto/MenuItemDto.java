package br.com.bluesburger.menu.adapters.in.menu.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class MenuItemDto {
	
	private Long id;
	
	private String description;

	private String name;

	private String category;

	private BigDecimal price;
}
