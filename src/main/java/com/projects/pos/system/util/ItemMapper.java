package com.projects.pos.system.util;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import com.projects.pos.system.dto.request.ItemRequestDTO;
import com.projects.pos.system.dto.response.ItemResponseDTO;
import com.projects.pos.system.entity.Item;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    Item requestDTOToEntity(ItemRequestDTO itemRequestDTO);
    ItemResponseDTO entityToResponseDTO(Item item);
    List<ItemResponseDTO> entityToDTO(List<Item> itemList);
    List<ItemResponseDTO> pageEntityToDTO(Page<Item> items);

}
