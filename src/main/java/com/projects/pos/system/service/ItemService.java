package com.projects.pos.system.service;

import java.util.List;

import com.projects.pos.system.dto.request.ItemRequestDTO;
import com.projects.pos.system.dto.response.CountOfActiveStatusInItems;
import com.projects.pos.system.dto.response.ItemResponseDTO;
import com.projects.pos.system.dto.response.PaginatedItemsResponseDTO;

public interface ItemService {
    public ItemResponseDTO saveItem(ItemRequestDTO itemRequestDTO);
    public List<ItemResponseDTO> getAllItems();

    public List<ItemResponseDTO> getActiveItems(boolean b);

    public CountOfActiveStatusInItems activeInactiveCount();

    public PaginatedItemsResponseDTO getPaginatedItems(int page, int size);

    public PaginatedItemsResponseDTO getActiveItemsPaginatedly(int page, int size);
}
