package br.com.bluesburger.menu.adapters.in.menu.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuItemRequest implements Serializable {

    private static final long serialVersionUID = -621830335594903665L;

    private Long id;

    private String description;
}
