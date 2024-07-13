package br.com.bluesburger.menu.adapters.out;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(schema = "bluesburger-menu", name = "TB_MENU")
public class MenuItem implements Serializable {

    private static final long serialVersionUID = -3541042247074947720L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Setter
    @Column(name = "NAME")
    private String name;

    @Setter
    @Column(name = "DESCRIPTION")
    private String description;

    @Setter
    @Column(name = "CATEGORY")
    private String category;

    @Setter
    @Column(name = "PRICE")
    private BigDecimal price;
}
