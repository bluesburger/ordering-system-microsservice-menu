package br.com.bluesburguer.menu.adapters.in.menu.dto;

import org.springframework.stereotype.Component;

import br.com.bluesburguer.menu.adapters.out.MenuItem;

@Component
public class MenuItemAssembler {

	public MenuItemDto from(MenuItem menuItem) {
		return new MenuItemDto(menuItem.getId(), menuItem.getDescription());
	}
	
	public MenuItem to(MenuItemDto menuItemDto) {
		return new MenuItem(menuItemDto.getId(), menuItemDto.getDescription());
	}
}
