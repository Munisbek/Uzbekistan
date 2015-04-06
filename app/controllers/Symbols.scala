package controllers

import play.api.mvc._
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick._
import models._
import play.api.Logger

import scala.slick.lifted.TableQuery


class Symbols extends Controller {

  val symbol = TableQuery[SymbolTable]

  def symbols = DBAction { implicit rs =>
    Logger.info(s"SHOW_ALL = ${symbol.list}")
    Ok(views.html.symbols(symbol.list))
  }

}
