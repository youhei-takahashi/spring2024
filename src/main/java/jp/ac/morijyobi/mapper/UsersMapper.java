package jp.ac.morijyobi.mapper;

import jp.ac.morijyobi.bean.dto.LoginUserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UsersMapper {

    @Select("SELECT u.id, u.username, u.password, " +
            "u.name, a.authority " +
            "FROM users AS u " +
            "INNER JOIN authorities AS a ON u.authority_id = a.id " +
            "WHERE u.username = #{username}")
    LoginUserDTO selectUserByUsername(String username);

}
