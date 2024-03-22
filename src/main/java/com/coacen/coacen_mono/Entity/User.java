package com.coacen.coacen_mono.Entity;
import com.coacen.coacen_mono.Service.User_Details_Service;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user_details")
/*
This User class that i have created for user information it extends to User Details
because spring can only understand and works with UserDetails class,hence i am extending
to it and implementing all its implemented methods, attaching my user class variables
with USer Details is done throough returning the data, for USer roles create a new enum
in same package and datatype for userRole is Role, Have 2 roles ADMIN and USER and
other things like account locked etc return true
 */
public class User implements UserDetails
{
    @NotBlank
    @Email
    private String userName;
    @NotBlank
    private String userPassword;
    @NotBlank
    @Enumerated(EnumType.STRING)
    private Role userRole;
    @Id
    private int userId;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(userRole.name()));
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
