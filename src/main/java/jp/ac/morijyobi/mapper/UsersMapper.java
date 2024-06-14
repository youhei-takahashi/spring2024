package jp.ac.morijyobi.mapper;

import jp.ac.morijyobi.bean.dto.LoginUserDTO;
import jp.ac.morijyobi.bean.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UsersMapper {

    @Select("SELECT u.id, u.username, u.password, " +
            "u.name, a.authority " +
            "FROM users AS u " +
            "INNER JOIN authorities AS a ON u.authority_id = a.id " +
            "WHERE u.username = #{username}")
    LoginUserDTO selectUserByUsername(String username);

    @Insert("INSERT INTO users VALUES(default, #{username}, #{password}, #{name}, #{authorityId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertUser(User user);

}
