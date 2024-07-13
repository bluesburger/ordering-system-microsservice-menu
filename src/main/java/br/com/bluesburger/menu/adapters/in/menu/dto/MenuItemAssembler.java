package br.com.bluesburger.menu.adapters.in.menu.dto;

import br.com.bluesburger.menu.adapters.out.MenuItem;
import org.springframework.stereotype.Component;

@Component
public class MenuItemAssembler {

	public MenuItemDto from(MenuItem menuItem) {
		return new MenuItemDto(
				menuItem.getId(),
				menuItem.getName(),
				menuItem.getDescription(),
				menuItem.getCategory(),
				menuItem.getPrice()
		);
	}

	public MenuItem to(MenuItemDto menuItemDto) {
		return new MenuItem(
				menuItemDto.getId(),
				menuItemDto.getName(),
				menuItemDto.getDescription(),
				menuItemDto.getCategory(),
				menuItemDto.getPrice()
		);
	}
}
