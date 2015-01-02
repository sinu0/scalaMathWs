package controllers

import play.api._
import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import models._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index())
  }

  val personForm: Form[Person] = Form {
  	mapping(
      "name" -> text
  	)(Person.apply)(Person.unapply)
  }

  def addPerson = Action { implicit request =>
  	val person = personForm.bindFromRequest.get
  	DB.save(person)  	
  	Redirect(routes.Application.index)
  }

  def getPersons = Action {
  	val persons = DB.query[Person].fetch()
  	Ok(Json.toJson(persons))
  }

  def add() = play.mvc.Results.TODO

  def subtract() = play.mvc.Results.TODO

  def transponse() = play.mvc.Results.TODO

  def divide() = play.mvc.Results.TODO

  def reverse() = play.mvc.Results.TODO

  def multiply() = play.mvc.Results.TODO
}