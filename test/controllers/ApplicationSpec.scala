package controllers

import org.specs2._

import play.api.test._
import play.api.test.Helpers._

class ApplicationSpec extends Specification {
  def is =
    "This is a specification to check Application controller" 	^
      															p ^
      "The Application should" 									^
      `respond to index action`

  def `respond to index action` = running(FakeApplication()) {
    val Some(result) = route(FakeRequest(GET, "/"))
    status(result) must equalTo(OK)
    contentType(result) must beSome("text/html")
    charset(result) must beSome("utf-8")
  }
}