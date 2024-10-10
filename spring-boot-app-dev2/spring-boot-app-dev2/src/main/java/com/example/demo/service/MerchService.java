package com.example.demo.service;

import com.example.demo.entity.MerchItem;
import com.example.demo.enums.MerchCategory;
import com.example.demo.repository.MerchItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing operations related to Merch Items.
 */
@Service
public class MerchService
{
    @Autowired
    private MerchItemRepository merchItemRepository;

    /**
     * Retrieve all merch items.
     *
     * @return List of all merch items.
     */
    public List<MerchItem> getAllMerchItems()
    {
        return merchItemRepository.findAll();
    }

    /**
     * Retrieve a merch item by its ID.
     *
     * @param id The ID of the merch item.
     * @return The merch item.
     * @throws ChangeSetPersister.NotFoundException If the merch item is not found.
     */
    public MerchItem getMerchItemById(Long id) throws ChangeSetPersister.NotFoundException
    {
        return merchItemRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    /**
     * Retrieve all merch items by category.
     *
     * @param category The category to filter merch items.
     * @return List of merch items in the specified category.
     */
    public List<MerchItem> getAllMerchByCategory(MerchCategory category)
    {
        return merchItemRepository.findByCategory(category);
    }

    /**
     * Create a new merch item.
     *
     * @param merchItem The merch item to be created.
     * @return The created merch item.
     */
    public MerchItem createMerchItem(MerchItem merchItem) {
        return merchItemRepository.save(merchItem);
    }

    /**
     * Update the price of a merch item.
     *
     * @param id The ID of the merch item to be updated.
     * @param price The new price for the merch item.
     * @return The updated merch item.
     * @throws Exception If the merch item is not found.
     */
    public MerchItem updateMerchItemPrice(Long id, double price) throws Exception {
        Optional<MerchItem> optionalMerchItem = merchItemRepository.findById(id);
        if (optionalMerchItem.isPresent()) {
            MerchItem merchItem = optionalMerchItem.get();
            merchItem.setPrice(price);
            return merchItemRepository.save(merchItem);
        } else {
            throw new Exception("MerchItem not found");
        }
    }

    /**
     * Update the quantity of a merch item.
     *
     * @param id The ID of the merch item to be updated.
     * @param quantity The new quantity for the merch item.
     * @return The updated merch item.
     * @throws Exception If the merch item is not found.
     */
    public MerchItem updateMerchItemQuantity(Long id, int quantity) throws Exception {
        Optional<MerchItem> optionalMerchItem = merchItemRepository.findById(id);
        if (optionalMerchItem.isPresent()) {
            MerchItem merchItem = optionalMerchItem.get();
            merchItem.setQuantity(quantity);
            return merchItemRepository.save(merchItem);
        } else {
            throw new Exception("MerchItem not found");
        }
    }

    /**
     * Delete a merch item by ID.
     *
     * @param id The ID of the merch item to be deleted.
     * @throws Exception If the merch item is not found.
     */
    public void deleteMerchItemById(Long id) throws Exception {
        Optional<MerchItem> optionalMerchItem = merchItemRepository.findById(id);
        if (optionalMerchItem.isPresent()) {
            merchItemRepository.deleteById(id);
        } else {
            throw new Exception("Merch item not found");
        }
    }

    /**
     * Delete all merch items in a specific category.
     *
     * @param category The category of merch items to delete.
     * @throws RuntimeException If no merch items are found in the specified category.
     */
    public void deleteMerchItemsByCategory(MerchCategory category) {
        List<MerchItem> merchItems = merchItemRepository.findByCategory(category);
        if (!merchItems.isEmpty()) {
            merchItemRepository.deleteAll(merchItems);
        } else {
            throw new RuntimeException("No merch items found in the category: " + category);
        }
    }
}