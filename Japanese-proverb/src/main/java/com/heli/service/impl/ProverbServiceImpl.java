package com.heli.service.impl;

import com.heli.mapper.ProverbMapper;
import com.heli.pojo.Proverb;
import com.heli.pojo.PageBean;
import com.heli.service.ProverbService;
import com.heli.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ProverbServiceImpl implements ProverbService {
    //1. 创建SqlSessionFactory 工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();


    @Override
    public List<Proverb> selectAll() {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取ProverbMapper
        ProverbMapper mapper = sqlSession.getMapper(ProverbMapper.class);

        //4. 调用方法
        List<Proverb> proverbs = mapper.selectAll();

        //5. 释放资源
        sqlSession.close();

        return proverbs;
    }

    @Override
    public void add(Proverb proverb) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取ProverbMapper
        ProverbMapper mapper = sqlSession.getMapper(ProverbMapper.class);

        //4. 调用方法
        mapper.add(proverb);
        sqlSession.commit();//提交事务

        //5. 释放资源
        sqlSession.close();
    }

    @Override
    public void deleteByIds(int[] ids) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取ProverbMapper
        ProverbMapper mapper = sqlSession.getMapper(ProverbMapper.class);

        //4. 调用方法
        mapper.deleteByIds(ids);

        sqlSession.commit();//提交事务

        //5. 释放资源
        sqlSession.close();
    }

    @Override
    public PageBean<Proverb> selectByPage(int currentPage, int pageSize) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取ProverbMapper
        ProverbMapper mapper = sqlSession.getMapper(ProverbMapper.class);


        //4. 计算开始索引
        int begin = (currentPage - 1) * pageSize;
        // 计算查询条目数
        int size = pageSize;

        //5. 查询当前页数据
        List<Proverb> rows = mapper.selectByPage(begin, size);

        //6. 查询总记录数
        int totalCount = mapper.selectTotalCount();

        //7. 封装PageBean对象
        PageBean<Proverb> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);


        //8. 释放资源
        sqlSession.close();

        return pageBean;
    }

    @Override
    public PageBean<Proverb> selectByPageAndCondition(int currentPage, int pageSize, Proverb proverb) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取ProverbMapper
        ProverbMapper mapper = sqlSession.getMapper(ProverbMapper.class);


        //4. 计算开始索引
        int begin = (currentPage - 1) * pageSize;
        // 计算查询条目数
        int size = pageSize;

        // 处理proverb条件，模糊表达式
        String Proverb_name_jp_kanji = proverb.getProverb_name_jp_kanji();
        if (Proverb_name_jp_kanji != null && Proverb_name_jp_kanji.length() > 0) {
            proverb.setProverb_name_jp_kanji("%" + Proverb_name_jp_kanji + "%");
        }

        String proverb_name_jp_kana = proverb.getProverb_name_jp_kana();
        if (proverb_name_jp_kana != null && proverb_name_jp_kana.length() > 0) {
            proverb.setProverb_name_jp_kana("%" + proverb_name_jp_kana + "%");
        }


        //5. 查询当前页数据
        List<Proverb> rows = mapper.selectByPageAndCondition(begin, size, proverb);

        //6. 查询总记录数
        int totalCount = mapper.selectTotalCountByCondition(proverb);

        //7. 封装PageBean对象
        PageBean<Proverb> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);


        //8. 释放资源
        sqlSession.close();

        return pageBean;
    }


}
