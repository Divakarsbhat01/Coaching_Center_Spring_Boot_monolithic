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
1. The User class contains fields for user identification fields
2. This user class is not understood by Spring boot's Security
3. Therefore i am attaching this class with UserDetails this is understood by SpringBoot Security
4.implementing its methods
5. making sure that all its implemented methods return proper values
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
