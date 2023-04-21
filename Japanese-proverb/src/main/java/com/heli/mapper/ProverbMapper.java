package com.heli.mapper;

import com.heli.pojo.Proverb;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProverbMapper {

    /**
     * 查询所有
     * @return
     */
    @Select("select * from tb_proverb")
    @ResultMap("proverbResultMap")
    List<Proverb> selectAll();

    /**
     * 添加数据
     * @param proverb
     */
    @Insert("insert into tb_proverb values(null,#{proverbName},#{companyName},#{ordered},#{description},#{status})")
    void add(Proverb proverb);


    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);

    /**
     * 分页查询
     * @param begin
     * @param size
     * @return
     */
    @Select("select * from tb_proverb limit #{begin} , #{size}")
    @ResultMap("proverbResultMap")
    List<Proverb> selectByPage(@Param("begin") int begin,@Param("size") int size);

    /**
     * 查询总记录数
     * @return
     */
    @Select("select count(*) from tb_proverb ")
    int selectTotalCount();



    /**
     * 分页条件查询
     * @param begin
     * @param size
     * @return
     */
    List<Proverb> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("proverb") Proverb proverb);

    /**
     * 根据条件查询总记录数
     * @return
     */
    int selectTotalCountByCondition(Proverb proverb);

}
