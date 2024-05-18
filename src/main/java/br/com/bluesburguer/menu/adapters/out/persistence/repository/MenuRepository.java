package br.com.bluesburguer.menu.adapters.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bluesburguer.menu.adapters.out.MenuItem;

public interface MenuRepository extends JpaRepository<MenuItem, Long> {

}
