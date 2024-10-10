package com.example.demo.service;

import com.example.demo.entity.MerchItem;
import com.example.demo.enums.MerchCategory;
import com.example.demo.repository.MerchItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchService
{
    @Autowired
    private MerchItemRepository merchItemRepository;

    public List<MerchItem> getAllMerchItems()
    {
        return merchItemRepository.findAll();
    }

    public MerchItem getMerchItemById(Long id) throws ChangeSetPersister.NotFoundException
    {
        return merchItemRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public List<MerchItem> getAllMerchByCategory(MerchCategory category)
    {
        return merchItemRepository.findByCategory(category);
    }

    public List<MerchItem> AddingMerchItem(MerchCategory category)
    {
        return merchItemRepository.findByCategory(category);
    }

    public MerchItem createMerchItem(MerchItem merchItem) {
        return merchItemRepository.save(merchItem);
    }
}