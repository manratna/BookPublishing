package com.bp.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bp.dao.TitleAuthorRepository;
import com.bp.dao.entity.Author;
import com.bp.dao.entity.Title;
import com.bp.dao.entity.TitleAuthor;
import com.bp.exception.TitleNotFoundException;
import com.bp.model.TitleAuthorDTO;

@Service
public class TitleAuthorServiceImpl implements TitleAuthorService {

 @Autowired
 private TitleAuthorRepository titleAuthorRepository;

 @Override
 public String addNewTitleAuthor(TitleAuthorDTO titleAuthorDTO) {
	 System.out.println(titleAuthorDTO);
     TitleAuthor titleAuthor = new TitleAuthor();
     titleAuthor.setRoyaltyPer(titleAuthorDTO.getRoyaltyPer());
     Title title = new Title();
     BeanUtils.copyProperties(titleAuthorDTO.getTitle(), title);
          titleAuthor.setTitle(title);
     Author author = new Author();
     BeanUtils.copyProperties(titleAuthorDTO.getAuthor(), author);
     titleAuthor.setAuthor(author);
     BeanUtils.copyProperties(titleAuthorDTO, titleAuthor);
     try {
    	 titleAuthorRepository.save(titleAuthor);
         return "Record Created Successfully";
     } catch (Exception e) {
         throw new TitleNotFoundException("Error creating TitleAuthor record");
     }
     
 }

}
