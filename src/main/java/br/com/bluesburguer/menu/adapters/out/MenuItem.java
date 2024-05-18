package br.com.bluesburguer.menu.adapters.out;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(schema = "bluesburguer-menu", name = "TB_MENU")
public class MenuItem implements Serializable {
	
	private static final long serialVersionUID = -3541042247074947720L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Setter
	@Column(name = "DESCRIPTION")
	private String description;
}
