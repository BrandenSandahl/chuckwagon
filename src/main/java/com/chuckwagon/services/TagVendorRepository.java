package com.chuckwagon.services;

import com.chuckwagon.entities.Tag;
import com.chuckwagon.entities.TagVendor;
import com.chuckwagon.entities.Vendor;
import com.sun.tools.javac.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by branden on 4/12/16 at 19:53.
 */
public interface TagVendorRepository extends CrudRepository<TagVendor, Integer> {
    @Modifying
    @Transactional
    @Query("delete from TagVendor tv where tv.vendor = ?1")
    void deleteByVendor(Vendor vendor);


    @Query(value = "select tag from tag_vendor where vendor_id = ?1", nativeQuery = true)
    Set<Tag> findByVendor(Integer id);

}