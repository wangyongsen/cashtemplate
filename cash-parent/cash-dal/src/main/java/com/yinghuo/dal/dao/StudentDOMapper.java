package com.yinghuo.dal.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.yinghuo.dal.entity.StudentDO;
import java.util.List;
import com.yinghuo.vo.StudentVo;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table STUDENT.
 * 学生表
 */
public interface StudentDOMapper{

    /**
     * desc:自定义SQL执行.<br/>
     * descSql =  SELECT * FROM STUDENT WHERE age = ?
     * @param age age
     * @return StudentDO
     */
    StudentDO queryByFullMinusNo(Long age);
    /**
     * desc:插入:STUDENT.<br/>
     * descSql =  INSERT INTO STUDENT( AGE ,NAME )VALUES( ? , ? )
     * @param entity entity
     * @return Long
     */
    Long insert(StudentDO entity);
    /**
     * desc:更新STUDENT数据.<br/>
     * descSql =  UPDATE STUDENT SET AGE = ? ,NAME =? ,card =? WHERE ID = ?
     * @param entity entity
     * @return Long
     */
    Long update(StudentDO entity);
    /**
     * desc:根据主键删除数据:STUDENT.<br/>
     * descSql =  DELETE FROM STUDENT WHERE ID =?
     * @param id id
     * @return Long
     */
    Long deleteByPrimary(Long id);
    /**
     * desc:根据主键获取数据:STUDENT.<br/>
     * descSql =  SELECT * FROM STUDENT WHERE ID = ?
     * @param id id
     * @return StudentDO
     */
    StudentDO getByPrimary(Long id);
    /**
     * desc:根据主键获取数据:STUDENT.<br/>
     * descSql =  SELECT * FROM STUDENT
     * @return List<StudentDO>
     */
    List<StudentDO> selectByConditon();
    
    /**
     * desc:根据条件获取数据:STUDENT.<br/>
     * descSql =  select s.`name`,s.`age`,d.`address`,s.`card` from student s inner join student_detail d on s.`id`=d.`student_id` where s.age=#{age,jdbcType=VARCHAR} and s.card=#{card,jdbcType=VARCHAR} and d.`address`=#{address,jdbcType=VARCHAR} 
     * @param age age
     * @param card card
     * @param address address
     * @return StudentVo
     */
    StudentVo getUnionTableByCondition(@Param("age")Long age,@Param("card")Long card,@Param("address")String address);
}
