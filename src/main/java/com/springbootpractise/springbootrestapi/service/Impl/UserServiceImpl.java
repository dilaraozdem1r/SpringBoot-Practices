package com.springbootpractise.springbootrestapi.service.Impl;

import com.springbootpractise.springbootrestapi.Entity.User;
import com.springbootpractise.springbootrestapi.advice.UserNotFound;
import com.springbootpractise.springbootrestapi.dto.UserDto;
import com.springbootpractise.springbootrestapi.repository.UserRepository;
import com.springbootpractise.springbootrestapi.service.UserService;
import com.springbootpractise.springbootrestapi.util.CustomPage;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user=modelMapper.map(userDto,User.class);
        user.setCreatedDate(new Date());
        user.setCreatedBy("admin");
        return modelMapper.map(userRepository.save(user), UserDto.class);
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> users=userRepository.findAll();
        List<UserDto> dtos=users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public UserDto getUser(Long id) {
    Optional<User> user=userRepository.findById(id);
    if(user.isPresent()){
        return modelMapper.map(user.get(), UserDto.class);
    }
        throw new RuntimeException("Kullanici Bulunamadi");
    }

    @Override
    public UserDto updateUser(Long id, UserDto user) {
        Optional<User> resultUser=userRepository.findById(id);
        if(resultUser.isPresent()){
             resultUser.get().setName(user.getName());
             resultUser.get().setLastname(user.getLastname());
             resultUser.get().setUpdatedBy("admin");
             resultUser.get().setUpdatedDate(new Date());
             return modelMapper.map(userRepository.save(resultUser.get()),UserDto.class);
        }
        return null;
    }

    @Override
    public Boolean deleteUser(Long id) {
        Optional<User> resultUser=userRepository.findById(id);
        if(resultUser.isPresent()){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Page<User> pagination(int currentPage, int pageSize) {
        Pageable pageable= PageRequest.of(currentPage,pageSize);
        return userRepository.findAll(pageable);
    }

    @Override
    public Page<User> pagination(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Slice<User> slice(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public CustomPage<UserDto> customPagination(Pageable pageable) {
        Page<User> data=userRepository.findAll(pageable);
        UserDto[] dtos=modelMapper.map(data.getContent(),UserDto[].class);
        return new CustomPage<UserDto>(data, Arrays.asList(dtos));

    }
}
