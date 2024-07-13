package br.com.bluesburger.menu.adapters.in.menu;

import br.com.bluesburger.menu.adapters.in.menu.dto.MenuItemAssembler;
import br.com.bluesburger.menu.adapters.in.menu.dto.MenuItemDto;
import br.com.bluesburger.menu.adapters.out.MenuItem;
import br.com.bluesburger.menu.core.service.MenuService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MenuRestResourceTest {

    @Mock
    private MenuService menuService;

    @Mock
    private MenuItemAssembler menuItemAssembler;

    @InjectMocks
    private MenuRestResource menuRestResource;

    private MenuItem menuItem1;
    private MenuItem menuItem2;
    private MenuItem menuItem3;
    private MenuItemDto menuItemDto1;
    private MenuItemDto menuItemDto2;
    private MenuItemDto menuItemDto3;

    @BeforeEach
    void setUp() {
        menuItem1 = new MenuItem(1L, "Burger", "", "", BigDecimal.TEN);
        menuItem2 = new MenuItem(2L, "Fries", "", "", BigDecimal.valueOf(5));
        menuItem3 = new MenuItem(3L, "Soda", "", "", BigDecimal.valueOf(3));

        menuItemDto1 = new MenuItemDto(1L, "Burger", "", "", BigDecimal.TEN);
        menuItemDto2 = new MenuItemDto(2L, "Fries", "", "", BigDecimal.valueOf(5));
        menuItemDto3 = new MenuItemDto(3L, "Soda", "", "", BigDecimal.valueOf(3));

        when(menuService.findAll()).thenReturn(List.of(menuItem1, menuItem2, menuItem3));
        when(menuItemAssembler.from(menuItem1)).thenReturn(menuItemDto1);
        when(menuItemAssembler.from(menuItem2)).thenReturn(menuItemDto2);
        when(menuItemAssembler.from(menuItem3)).thenReturn(menuItemDto3);
    }

    @Test
    void testGetAll_returnsCorrectOrder() {
        List<MenuItemDto> menuItemDtos = menuRestResource.getAll();

        assertNotNull(menuItemDtos);
        assertEquals(3, menuItemDtos.size());
        assertEquals(menuItemDto1, menuItemDtos.get(0));
        assertEquals(menuItemDto2, menuItemDtos.get(1));
        assertEquals(menuItemDto3, menuItemDtos.get(2));
    }

    @Test
    void testGetAll_returnsEmptyList() {
        when(menuService.findAll()).thenReturn(List.of());

        List<MenuItemDto> menuItemDtos = menuRestResource.getAll();

        assertNotNull(menuItemDtos);
        assertEquals(0, menuItemDtos.size());
    }

    @Test
    void testGetAll_returnsListWithOneItem() {
        when(menuService.findAll()).thenReturn(List.of(menuItem1));

        List<MenuItemDto> menuItemDtos = menuRestResource.getAll();

        assertNotNull(menuItemDtos);
        assertEquals(1, menuItemDtos.size());
        assertEquals(menuItemDto1, menuItemDtos.get(0));
    }

    @Test
    void testGetAll_returnsListWithDifferentOrder() {
        when(menuService.findAll()).thenReturn(List.of(menuItem3, menuItem1, menuItem2));

        List<MenuItemDto> menuItemDtos = menuRestResource.getAll();

        assertNotNull(menuItemDtos);
        assertEquals(3, menuItemDtos.size());
        assertEquals(menuItemDto3, menuItemDtos.get(0));
        assertEquals(menuItemDto1, menuItemDtos.get(1));
        assertEquals(menuItemDto2, menuItemDtos.get(2));
    }
}