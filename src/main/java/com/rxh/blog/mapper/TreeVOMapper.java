package com.rxh.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rxh.blog.Utiles.TreeVO;
import com.rxh.blog.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TreeVOMapper extends BaseMapper<TreeVOMapper> {
  
     
    List<TreeVO> selectAllTree() ;

    List<Comment> findAllComment();
    List<Comment> findReplay();

}