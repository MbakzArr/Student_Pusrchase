/**
 * Controller class for handling operations related to Merch Items.
 * @Author: Mbadaliga Arehone
 * @Version 1.0
 */

package com.example.demo.controller;

import com.example.demo.entity.MerchItem;
import com.example.demo.enums.MerchCategory;
import com.example.demo.service.MerchService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/merch")
public class MerchItemController
{
    @Autowired
    private MerchService merchService;
    private StudentService studentService;

    /**
     * Get all merch items.
     *
     * @return List of all merch items.
     */
    @GetMapping("/all")
    public List<MerchItem> getAllMerchItems()
    {
        return merchService.getAllMerchItems();
    }

    /**
     * Create a new merch item.
     *
     * @param merchItem The merch item to be created.
     * @return The created merch item.
     */
    @PostMapping("/create")
    public MerchItem createMerchItem(@RequestBody MerchItem merchItem)
    {
        return merchService.createMerchItem(merchItem);
    }

    /**
     * Get merch items by category.
     *
     * @param category The category to filter merch items.
     * @return List of merch items in the specified category.
     */
    @GetMapping("/category")
    public List<MerchItem> getMerchItemsByCategory(MerchCategory category)
    {
        return merchService.getAllMerchByCategory(category);
    }

//    @PutMapping("/update/{id}/price")
//    public ResponseEntity<MerchItem> updateMerchItemPrice(@PathVariable Long id, @RequestParam double price) {
//        try {
//            MerchItem updatedItem = merchService.updateMerchItemPrice(id, price);
//            return new ResponseEntity<>(updatedItem, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PutMapping("/update/{id}/quantity")
//    public ResponseEntity<MerchItem> updateMerchItemQuantity(@PathVariable Long id, @RequestParam int quantity) {
//        try {
//            MerchItem updatedItem = merchService.updateMerchItemQuantity(id, quantity);
//            return new ResponseEntity<>(updatedItem, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//}


    /**
     * Update the price of a merch item.
     *
     * @param id The ID of the merch item to be updated.
     * @param merchItem The merch item with the updated price.
     * @return ResponseEntity with the updated merch item.
     */
    @PutMapping("/update/{id}/price")
    public ResponseEntity<MerchItem> updateMerchItemPrice(@PathVariable Long id, @RequestBody MerchItem merchItem) {
        try {
            MerchItem updatedItem = merchService.updateMerchItemPrice(id, merchItem.getPrice());
            return new ResponseEntity<>(updatedItem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Update the quantity of a merch item.
     *
     * @param id The ID of the merch item to be updated.
     * @param merchItem The merch item with the updated quantity.
     * @return ResponseEntity with the updated merch item.
     */
    @PutMapping("/update/{id}/quantity")
    public ResponseEntity<MerchItem> updateMerchItemQuantity(@PathVariable Long id, @RequestBody MerchItem merchItem) {
        try {
            MerchItem updatedItem = merchService.updateMerchItemQuantity(id, merchItem.getQuantity());
            return new ResponseEntity<>(updatedItem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Delete a merch item by ID.
     *
     * @param id The ID of the merch item to delete.
     * @return ResponseEntity with the status of the operation.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMerchItem(@PathVariable Long id) {
        try {
            merchService.deleteMerchItemById(id);
            return new ResponseEntity<>("Merch item deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Merch item not found", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Delete all merch items in a specific category.
     *
     * @param category The category of merch items to delete.
     * @return ResponseEntity with the status of the operation.
     */
    @DeleteMapping("/delete/category/{category}")
    public ResponseEntity<String> deleteMerchItemsByCategory(@PathVariable MerchCategory category) {
        try {
            merchService.deleteMerchItemsByCategory(category);
            return new ResponseEntity<>("All merch items in the category " + category + " deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred while deleting merch items in the category", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}