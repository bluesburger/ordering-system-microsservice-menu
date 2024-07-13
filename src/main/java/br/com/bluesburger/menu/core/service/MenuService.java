package br.com.bluesburger.menu.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.bluesburger.menu.adapters.in.menu.dto.MenuItemRequest;
import br.com.bluesburger.menu.adapters.out.MenuItem;
import br.com.bluesburger.menu.adapters.out.persistence.repository.MenuRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(Transactional.TxType.SUPPORTS)
public class MenuService {
	
	private final MenuRepository menuRepository;

	public List<MenuItem> findAll() {
		return menuRepository.findAll();
	}
	
	public MenuItem save(MenuItemRequest menuItemRequest) {
		var item = new MenuItem();
		item.setDescription(menuItemRequest.getDescription());
		return menuRepository.save(item);
	}
	
	public Optional<MenuItem> getById(Long id) {
		try {
			return Optional.ofNullable(menuRepository.getReferenceById(id));
		} catch(EntityNotFoundException e) {
			return Optional.empty();
		}
	}
	
	public Optional<MenuItem> update(Long menuItemId, MenuItemRequest menuItem) {
		return getById(menuItemId)
			.map(existantItem -> {
				existantItem.setDescription(menuItem.getDescription());
				return menuRepository.save(existantItem);
			});
	}
	
	public void deleteById(Long id) {
		getById(id).ifPresent(menuRepository::delete);
	}
}
