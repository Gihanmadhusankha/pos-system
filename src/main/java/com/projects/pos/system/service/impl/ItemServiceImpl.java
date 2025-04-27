package com.projects.pos.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.projects.pos.system.dto.request.ItemRequestDTO;
import com.projects.pos.system.dto.response.CountOfActiveStatusInItems;
import com.projects.pos.system.dto.response.ItemResponseDTO;
import com.projects.pos.system.dto.response.PaginatedItemsResponseDTO;
import com.projects.pos.system.entity.Item;
import com.projects.pos.system.exception.EntryDuplicationException;
import com.projects.pos.system.repository.ItemRepo;
import com.projects.pos.system.service.ItemService;
import com.projects.pos.system.util.ItemMapper;

import java.awt.*;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ItemMapper itemMapper;



    @Override
    public ItemResponseDTO saveItem(ItemRequestDTO itemRequestDTO) {
        Item item = itemMapper.requestDTOToEntity(itemRequestDTO);
        item.setActiveStatus(true);

        itemRepo.save(item);
        System.out.println(itemRepo.existsById(item.getItemId()));
        return itemMapper.entityToResponseDTO(item);
    }

    @Override
    public List<ItemResponseDTO> getAllItems() {
        List<Item> itemList = itemRepo.findAll();
        return itemMapper.entityToDTO(itemList);
    }

    @Override
    public List<ItemResponseDTO> getActiveItems(boolean b) {
        List<Item> itemList = itemRepo.findAllByActiveStatusEquals(b);
        return itemMapper.entityToDTO(itemList);
    }

    @Override
    public CountOfActiveStatusInItems activeInactiveCount() {
        List<Item> itemList = itemRepo.findAll();
        List<Item> activeItemList = itemRepo.findAllByActiveStatusEquals(true);

        int totalItemsCount = itemList.size();
        int activeItemsCount = activeItemList.size();
        int inactiveItemsCount = (totalItemsCount-activeItemsCount);

        CountOfActiveStatusInItems countOfActiveStatusInItems = new CountOfActiveStatusInItems(
                activeItemsCount,
                inactiveItemsCount
        );
        return countOfActiveStatusInItems;
    }

    @Override
    public PaginatedItemsResponseDTO getPaginatedItems(int page, int size) {
        Page<Item> items = itemRepo.findAll(PageRequest.of(page,size));
        PaginatedItemsResponseDTO paginatedItemsResponseDTO = new PaginatedItemsResponseDTO(
                itemMapper.pageEntityToDTO(items),
                (double) itemRepo.count()
        );
        return paginatedItemsResponseDTO;
    }

    @Override
    public PaginatedItemsResponseDTO getActiveItemsPaginatedly(int page, int size) {
        Page<Item> items = itemRepo.findAllByActiveStatusEquals(true , PageRequest.of(page,size));
        PaginatedItemsResponseDTO paginatedItemsResponseDTO = new PaginatedItemsResponseDTO(
                itemMapper.pageEntityToDTO(items),
                (double) itemRepo.findAllByActiveStatusEquals(true).size()
        );
        return paginatedItemsResponseDTO;
    }


}

