package com.rxh.blog.Utiles;

import java.util.List;

public class TreeVO {
     
    private Integer id;
    private String name;
    private Integer pid;
    private List<TreeVO> list;
  
    public Integer getId() {
        return id;
    }
  
    public void setId(Integer id) {
        this.id = id;
    }
  
    public String getName() {
        return name;
    }
  
    public void setName(String name) {
        this.name = name;
    }
  
    public Integer getPid() {
        return pid;
    }
  
    public void setPid(Integer pid) {
        this.pid = pid;
    }
  
    public List<TreeVO> getList() {
        return list;
    }
  
    public void setList(List<TreeVO> list) {
        this.list = list;
    }
     
}