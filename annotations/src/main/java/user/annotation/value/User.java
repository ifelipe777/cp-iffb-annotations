package user.annotation.value;


import lombok.Builder;
import lombok.Value;
import user.annotation.validator.Password;

import javax.validation.constraints.Pattern;

@Value
@Builder
public class User {

   @Pattern(regexp ="^[a-zA-z]+$", message = "should be alpha numeric")
   String username;

   @Password
   String password;
}
