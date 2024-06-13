package jp.ac.morijyobi.service.impl;

import jp.ac.morijyobi.bean.dto.LoginUserDTO;
import jp.ac.morijyobi.mapper.UsersMapper;
import jp.ac.morijyobi.security.LoginUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UsersMapper usersMapper;

    public UserDetailServiceImpl(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        LoginUserDTO user = usersMapper.selectUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found for name: " + username);
        }

        return new LoginUserDetails(user);
    }
}
