package controllers

import models._
import play.api.Logger
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick._
import play.api.mvc._

import scala.slick.lifted.TableQuery

class Countries extends Controller {

  val countries = TableQuery[CountryTable]

  def list = DBAction { implicit rs =>
    Ok(views.html.listCountries(countries.list))
  }

  def showAddForm = DBAction { implicit rs =>
    Ok(views.html.addCountry())
  }


  def add = DBAction { implicit request =>
    val formParams = request.body.asFormUrlEncoded
    val name = formParams.get("name")(0)
    val cityId = (countries returning countries.map(_.id)) += Country(None, name)
    Logger.info(s"LastId = $cityId")
    Redirect(routes.Countries.list())
  }


  def remove(id: Int) = DBAction { implicit request =>
    countries.filter(_.id === id).delete;
    Redirect(routes.Countries.list())
  }

  def update(id: Int) = DBAction { implicit rs =>
    val formParams = rs.body.asFormUrlEncoded
    val name = formParams.get("name")(0)

    val country = Country(Some(id), name)
    countries.filter(_.id === id).update(country)

    Redirect(routes.Countries.list())
  }

  def showEditForm(countryId: Int) = DBAction { implicit request =>
    val byId = countries.findBy(_.id)
    val country = byId(countryId).list.head

    Ok(views.html.editCountry(country))
  }

}