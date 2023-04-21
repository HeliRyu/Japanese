package com.heli.service;

import com.heli.pojo.PageBean;
import com.heli.pojo.Proverb;

import java.util.List;

public interface ProverbService {

    /**
     * 查询所有
     *
     * @return
     */
    List<Proverb> selectAll();

    /**
     * 添加数据
     *
     * @param proverb
     */
    void add(Proverb proverb);


    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds( int[] ids);

    /**
     * 分页查询
     * @param currentPage  当前页码
     * @param pageSize   每页展示条数
     * @return
     */
    PageBean<Proverb> selectByPage(int currentPage, int pageSize);

    /**
     * 分页条件查询
     * @param currentPage
     * @param pageSize
     * @param proverb
     * @return
     */
    PageBean<Proverb>  selectByPageAndCondition(int currentPage,int pageSize,Proverb proverb);

}
