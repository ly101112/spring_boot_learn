package com.test.www.mapper;

import com.test.www.model.Question;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface QuestionMapper {

    @Insert("INSERT INTO question (title, description, create_time, modified_time, uid, tag) VALUES (#{title}, #{description}, #{createTime}, #{modifiedTime}, #{uid}, #{tag})")
    void insertQuestion(Question question);

    @Select("SELECT * FROM question LIMIT #{start}, #{size}")
    List<Question> list(@Param(value = "start") Integer start, @Param(value = "size") Integer size);

    @Select("SELECT COUNT(1) FROM question")
    Integer total();

    @Select("SELECT * FROM question WHERE uid = #{id} LIMIT #{start}, #{size} ")
    List<Question> listByUserId(@Param(value = "id") Integer id, @Param(value = "start") Integer start, @Param(value = "size") Integer size);

    @Select("SELECT COUNT(1) FROM question WHERE uid = #{id}")
    Integer userTotal(@Param(value = "id") Integer id);

    @Select("SELECT * FROM question WHERE id = #{id}")
    Question findById(@Param(value = "id") Integer id);

    @Update("UPDATE question SET title = #{title}, description = #{description}, modified_time = #{modifiedTime}, tag = #{tag} WHERE id = #{id}")
    void update(Question question);
}
