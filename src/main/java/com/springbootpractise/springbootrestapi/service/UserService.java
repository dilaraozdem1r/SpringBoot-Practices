package com.springbootpractise.springbootrestapi.service;

import com.springbootpractise.springbootrestapi.Entity.User;
import com.springbootpractise.springbootrestapi.dto.UserDto;
import com.springbootpractise.springbootrestapi.util.CustomPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    List<UserDto> getUsers();
    UserDto getUser(Long id);

    UserDto updateUser(Long id, UserDto user);

    Boolean deleteUser(Long id);

    Page<User> pagination(int currentPage, int pageSize);

    Page<User> pagination(Pageable pageable);

    Slice<User> slice(Pageable pageable);

    CustomPage<UserDto> customPagination(Pageable pageable);
}
