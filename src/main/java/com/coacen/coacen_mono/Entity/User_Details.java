package com.coacen.coacen_mono.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user_details")
public class User_Details
{
    @NotBlank
    @Email
    private String userName;
    @NotBlank
    private String userPassword;
    @NotBlank
    private String userRole;
    @Id
    private int userId;
}
