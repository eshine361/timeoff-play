package test.models

import org.specs2.mutable._
import org.specs2.mock._

import models.User

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