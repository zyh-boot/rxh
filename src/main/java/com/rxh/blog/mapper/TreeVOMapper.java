package com.rxh.blog.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.rxh.blog.Utiles.TreeVO;
import com.rxh.blog.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TreeVOMapper extends BaseMapper<TreeVOMapper> {
  
     
    List<TreeVO> selectAllTree() ;
    boolean updataId(String id) ;
    List<TreeVO> findPage(@Param(Constants.WRAPPER) Wrapper query) ;

    List<Comment> findAllComment();
    List<Comment> findReplay();

}