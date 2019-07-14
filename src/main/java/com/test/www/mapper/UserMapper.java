package com.test.www.mapper;

import com.test.www.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {
    @Insert("INSERT INTO user (name, account_id, token, creat_time, modified_time, avatar_url) VALUES (#{name}, #{account_id}, #{token}, #{creat_time}, #{modified_time}, #{avatarUrl})")
    void insertUser(User user);

    @Select("SELECT * FROM user WHERE token = '#{token}'")
    User findByToken(@Param("token") String token);

    @Select("SELECT * FROM user WHERE id = #{id}")
    User findByID(@Param("id") Integer id);
}
