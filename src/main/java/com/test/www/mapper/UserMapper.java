package com.test.www.mapper;

import com.test.www.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {
    @Insert("INSERT INTO user (name, account_id, token, creat_time, modified_time, avatar) VALUES (#{name}, #{account_id}, #{token}, #{creat_time}, #{modified_time}, #{avatarUrl})")
    void insertUser(User user);

    @Select("SELECT * FROM user WHERE token = '#{token}'")
    User findByToken(@Param("token") String token);

    @Select("SELECT * FROM user WHERE id = #{id}")
    User findByID(@Param("id") Integer id);

    @Select("SELECT * FROM user WHERE account_id = #{accountId}")
    User findByAccountId(@Param("accountId") String accountId);

    @Update("UPDATE user SET name = #{name}, token = #{token}, avatar = #{avatarUrl}, modified_time = #{modifiedTime} WHERE id = #{id}")
    void update(User user);
}
