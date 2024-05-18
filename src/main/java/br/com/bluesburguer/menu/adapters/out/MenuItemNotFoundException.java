package br.com.bluesburguer.menu.adapters.out;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Item não encontrado")
public class MenuItemNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -4039534595214046018L;

}
