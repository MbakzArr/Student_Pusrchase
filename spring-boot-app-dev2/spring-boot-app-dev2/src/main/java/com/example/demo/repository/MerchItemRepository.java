package com.example.demo.repository;

import com.example.demo.entity.MerchItem;
import com.example.demo.enums.MerchCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MerchItemRepository extends JpaRepository<MerchItem, Long>
{
    /**
     * Find all merch items by their category.
     *
     * @param category The category of the merch items to search for.
     * @return A list of merch items in the specified category.
     */
    List<MerchItem> findByCategory(MerchCategory category);
}