package com.scraping.training.news;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RssFeedEntryRepository extends JpaRepository<RssFeedEntry, Long> {
    // Custom query methods can be added here if needed
}