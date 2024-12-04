package dev.ducku.bankingproject.dtos;

import dev.ducku.bankingproject.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {
    private String firstName;
    private String lastName;
    private String otherName;
    private User.GENDER gender;
    private String address;
    private String stateOfOrigin;
    private String phone;
    private String alternativePhone;
    private String email;
}
