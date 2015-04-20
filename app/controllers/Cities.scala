package controllers

import play.api.mvc._
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick._
import models._
import play.api.Logger

import scala.slick.lifted.TableQuery

class Cities extends Controller {

  val cities = TableQuery[CityTable]
  val commit = TableQuery[CountryTable]

  def list = DBAction { implicit rs =>
    //    Logger.info(s"SHOW_ALL = ${cities.list}")
    val cityResult = (for {
      (city, country) <- cities leftJoin commit on (_.countryId === _.id)
      } yield (city, country.name)).list
      .map { case (city, countryName) => CityForDisplay(city, countryName)}

    Ok(views.html.list(cityResult))
  }


  def showAddForm = DBAction { implicit rs =>
    Ok(views.html.add(commit.list))
  }

  def add = DBAction { implicit request =>
    val formParams = request.body.asFormUrlEncoded
    val name = formParams.get("name")(0)
    val description = formParams.get("description")(0)
    val countryId = formParams.get("country")(0).toInt

    val cityId = (cities returning cities.map(_.id)) += City(None, name, description, countryId)
    Logger.info(s"LastId = $cityId")
    Redirect(routes.Cities.list())
  }


  def remove(id: Int) = DBAction { implicit request =>
    cities.filter(_.id === id).delete;
    Redirect(routes.Cities.list())
  }

  def update(id: Int) = DBAction { implicit rs =>
    val formParams = rs.body.asFormUrlEncoded
    val name = formParams.get("name")(0)
    val description = formParams.get("description")(0)
    val countryId = formParams.get("country")(0).toInt

    val city = City(Some(id), name, description, countryId)
    cities.filter(_.id === id).update(city)

    Redirect(routes.Cities.list())
  }

  def showEditForm(cityId: Int) = DBAction { implicit request =>
    val byId = cities.findBy(_.id)
    val city = byId(cityId).list.head

    Ok(views.html.edit(city, commit.list))
  }

}