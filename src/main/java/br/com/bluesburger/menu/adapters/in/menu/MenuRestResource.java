package br.com.bluesburger.menu.adapters.in.menu;

import java.net.URI;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bluesburger.menu.adapters.in.menu.dto.MenuItemAssembler;
import br.com.bluesburger.menu.adapters.in.menu.dto.MenuItemDto;
import br.com.bluesburger.menu.adapters.in.menu.dto.MenuItemRequest;
import br.com.bluesburger.menu.adapters.out.MenuItemNotFoundException;
import br.com.bluesburger.menu.core.service.MenuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/menu")
@RequiredArgsConstructor
public class MenuRestResource {
	
	private final MenuItemAssembler menuItemAssembler;
	
	private final MenuService menuService;
	
	@GetMapping
	public List<MenuItemDto> getAll() {
		return menuService.findAll().stream()
			.map(menuItemAssembler::from)
			.toList();
	}
	
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<URI> createNewItem(@Valid @RequestBody MenuItemRequest menuItemRequest) {
		var menuItemDto = menuItemAssembler.from(menuService.save(menuItemRequest));
		URI location = URI.create(String.valueOf(menuItemDto.getId()));
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(value = "/{menuItemId}")
	public MenuItemDto updateMenuItem(@PathVariable Long menuItemId, @Valid @RequestBody MenuItemRequest menuItemRequest) {
		return menuService.update(menuItemId, menuItemRequest)
				.map(menuItemAssembler::from)
				.orElseThrow(MenuItemNotFoundException::new);
	}
	
	@GetMapping("/{id}")
	public MenuItemDto getById(@PathVariable Long id) {
		return menuService.getById(id)
				.map(menuItemAssembler::from)
				.orElseThrow(MenuItemNotFoundException::new);
	}
	
	@DeleteMapping("/{orderId}")
	public ResponseEntity<Void> deleteById(@PathVariable Long orderId) {
		menuService.deleteById(orderId);
		return ResponseEntity.noContent().build();
	}

}
