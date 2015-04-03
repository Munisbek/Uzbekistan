package controllers

/**
* Created by Munis on 24.03.2015.
*/

import play.api.mvc._
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick._
import models._
import play.api.Logger

import scala.slick.lifted.TableQuery


class Regions extends  Controller {

  val region = TableQuery[RegionsTable]

  def list = DBAction { implicit rs =>
    Logger.info(s"SHOW_ALL = ${region.list}")
    Ok(views.html.list(region.list))
  }


  def remove(id: Int) = DBAction { implicit request =>
    region.filter(_.id === id).delete;
    Redirect(routes.Regions.list())
  }


}


