package controllers

import play.api._
import play.api.mvc.{Flash, Action, Controller}
import play.api.data._
import play.api.data.Forms.{tuple, email, nonEmptyText}

import views._
import models.User

object Application extends Controller {
  private val loginForm = Form(
      tuple(
          "email" -> email,
          "password" -> nonEmptyText
      ) verifying ("Invalid email or password", result => result match {
        case (email, password) => User.authenticate(email, password)
      })
  );
  
  def login = Action { implicit request =>
    Ok(html.login(loginForm))
  }
  
  def authenticate = Action { implicit request =>
    loginForm.bindFromRequest.fold(
        formWithErrors => BadRequest(html.login(formWithErrors)),
        user => Redirect(routes.Leave.book).withSession("email" -> user._1)
    )
  }
  
  def logout = Action {
    Redirect(routes.Application.login).withNewSession.flashing(
        "success" -> "You've have been logged out"
    )
  }
}