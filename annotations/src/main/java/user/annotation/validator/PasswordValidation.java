package user.annotation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidation implements ConstraintValidator<Password, String> {

   private static final boolean NUMBER_OF_REQUIRED_DIGITS = true;

   @Override
   public void initialize(Password constraintAnnotation) {

   }

   @Override
   public boolean isValid(String password, ConstraintValidatorContext context) {
      return password == null || validate(password);
   }

   public static boolean validate(String password) {
      if (password == null || password.length() == 0) {
         return Boolean.TRUE;
      } else if (password.length() < 10 || password.length() > 15){
         return Boolean.FALSE;
      }

      Boolean requiredNumbers = Boolean.FALSE;
      for(char passwordLetter : password.toCharArray()){
         if(Character.isDigit(passwordLetter)) {
            requiredNumbers = Boolean.TRUE;
         } else if(Character.isSpaceChar(passwordLetter)){
            return Boolean.FALSE;
         }
      }

      return requiredNumbers;
   }
}
