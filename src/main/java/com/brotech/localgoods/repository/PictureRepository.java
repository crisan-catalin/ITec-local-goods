package com.brotech.localgoods.repository;

import com.brotech.localgoods.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Long> {
}
