package com.example.paystackwalletintegration.service;

import com.example.paystackwalletintegration.dto.SignUpDto;
import com.example.paystackwalletintegration.model.UserModel;
import com.example.paystackwalletintegration.model.WalletModel;
import com.example.paystackwalletintegration.repository.UserRepository;
import com.example.paystackwalletintegration.repository.WalletRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@Slf4j
public class UserService implements UserDetailsService {

    private final UserRepository userRepo;
    private final WalletRepository walletRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepo, WalletRepository walletRepo) {
        this.userRepo = userRepo;
        this.walletRepo = walletRepo;
    }

    public String registerUser(SignUpDto signUpDto){

        UserModel user = new UserModel();
        WalletModel wallet = new WalletModel();
        WalletModel savedWallet = walletRepo.save(wallet);

        if(userRepo.findByEmail(signUpDto.getEmail()) != null){
            return "A user with this email already exists, please use another";
        }

        user.setFirstName(signUpDto.getFirstName());
        user.setLastName(signUpDto.getLastName());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        user.setWalletModel(wallet);
        userRepo.save(user);
        return "User saved with details: " + signUpDto;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user =userRepo.findByEmail(username);

        if(user == null){
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        }else{
            log.info("User found in the database: {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}
