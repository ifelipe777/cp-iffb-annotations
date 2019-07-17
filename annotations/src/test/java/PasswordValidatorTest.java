import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import user.annotation.value.User;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class PasswordValidatorTest {

   private static ValidatorFactory validatorFactory;
   private static Validator validator;

   @BeforeClass
   public static void setUp(){
      validatorFactory = Validation.buildDefaultValidatorFactory();
      validator = validatorFactory.getValidator();
   }

   @Test
   public void validatePasswordTest(){
      final User user = User.builder().username("iffb").password("abcdefgh123").build();
      final Set<ConstraintViolation<User>> violations = validator.validate(user);
      Assert.assertTrue(violations.size() == 0);
   }

   @Test
   public void validatePasswordValidationErrorTest(){
      final User user = User.builder().username("iffb").password("abcd").build();
      final Set<ConstraintViolation<User>> violations = validator.validate(user);
      Assert.assertTrue(violations.size() > 0);
   }
}
