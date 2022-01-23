package com.gu.drools.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityDateMapper {
    @Select("select * from entitydate where id = #{id}")
    EntityDateMapper getByEntity(int id);
}
