package models

import org.specs2.mutable._

class UserSpec extends Specification {
  "User" should {
    "authenticate" in {
      User.authenticate("staff@example.com", "123456")
    }
    
    "not authenticate" in {
      !User.authenticate("staff@example.com", "2212")
    }
    
    "not authenticate" in {
      !User.authenticate("abc@abc", "21e1")
    }
  }
}