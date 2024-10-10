package com.example.demo.repository;

import com.example.demo.entity.MerchItem;
import com.example.demo.enums.MerchCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MerchItemRepository extends JpaRepository<MerchItem, Long>
{
    List<MerchItem> findByCategory(MerchCategory category);
    List<MerchItem> findBySize(String size);
}