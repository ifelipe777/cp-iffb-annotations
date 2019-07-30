package user.annotation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomEmailValidator implements ConstraintValidator<Email, String> {

   @Override
   public void initialize(Email constraintAnnotation) {

   }

   @Override
   public boolean isValid(String email, ConstraintValidatorContext context) {
      return validate(email);
   }

   private boolean validate(final String email){
      if(email == null)
         return Boolean.FALSE;

      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
      return email.matches(regex);
   }
}
