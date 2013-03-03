package models

case class User(email: String, password: String)

object User {
  val users = List(
      User("staff@example.com", "123456"),
      User("admin@example.com", "123456")
  )
  
  def authenticate(email: String, password: String) = users.exists(u => u.email == email && u.password == password)
}